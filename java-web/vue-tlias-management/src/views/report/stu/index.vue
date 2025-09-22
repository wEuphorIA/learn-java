<template>
  <div class="class-statistics">
    <div class="header">
      <h1>学员信息统计</h1>
      <p class="subtitle">基于教育机构提供的班级数据分析</p>
    </div>

    <div v-if="loading" class="loading-container">
      <div class="loader"></div>
      <p>数据加载中...</p>
    </div>

    <div v-else-if="error" class="error-container">
      <div class="error-icon">⚠️</div>
      <h2>数据加载失败</h2>
      <p>{{ error }}</p>
      <button @click="fetchData" class="retry-btn">重新加载</button>
    </div>

    <div v-else class="dashboard-content">
      <!-- 新增：左右分栏容器 -->
      <div class="chart-row">
        <!-- 左侧：班级人数图表 -->
        <div class="chart-col">
          <div class="chart-card">
            <div class="chart-header">
              <h2>各班级学员人数</h2>
              <div class="chart-legend">
                <span class="legend-item">
                  <span class="color-dot blue"></span>
                  班级人数
                </span>
              </div>
            </div>
            <div ref="classChartContainer" class="chart"></div>
          </div>
        </div>

        <!-- 右侧：学员学历图表 -->
        <div class="chart-col">
          <div class="chart-card">
            <div class="chart-header">
              <h2>学员学历统计</h2>
              <div class="chart-legend">
                <span class="legend-item" v-for="(item, index) in educationLegend" :key="index">
                  <span class="color-dot" :style="{ backgroundColor: item.color }"></span>
                  {{ item.name }}
                </span>
              </div>
            </div>
            <div ref="eduChartContainer" class="chart"></div>
          </div>
        </div>
      </div>

      <div class="summary-section">
        <h3>数据摘要</h3>
        <div class="stats-grid">
          <div class="stat-card">
            <div class="stat-icon">👨‍🎓</div>
            <div class="stat-value">{{ totalStudents }}</div>
            <div class="stat-label">学员总数</div>
          </div>
          <div class="stat-card">
            <div class="stat-icon">📊</div>
            <div class="stat-value">{{ classData.clazzList?.length || 0 }}</div>
            <div class="stat-label">班级数量</div>
          </div>
          <div class="stat-card">
            <div class="stat-icon">🎓</div>
            <div class="stat-value">{{ highestEducation?.name || "-" }}</div>
            <div class="stat-label">最高学历占比</div>
          </div>
          <div class="stat-card">
            <div class="stat-icon">📈</div>
            <div class="stat-value">{{ maxClassSize }}</div>
            <div class="stat-label">最大班级人数</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, onUnmounted, nextTick } from "vue";
import { getStudentCountData, getStudentDegreeData } from "@/api/report";
export default {
  name: "ClassStatistics",
  setup() {
    // 响应式数据
    const educationData = ref([]);
    const classData = ref({ clazzList: [], dataList: [] });
    const loading = ref(true);
    const error = ref(null);
    const classChartContainer = ref(null);
    const eduChartContainer = ref(null);
    let classChartInstance = null;
    let eduChartInstance = null;

    // 计算属性
    const totalStudents = ref(0);
    const highestEducation = ref(null);
    const maxClassSize = ref(0);

    // 学历图例数据
    const educationLegend = ref([
      { name: "初中", color: "#6699FF" },
      { name: "高中", color: "#99CC00" },
      { name: "大专", color: "#666666" },
      { name: "本科", color: "#FF9966" },
      { name: "硕士", color: "#00CCFF" },
      { name: "博士", color: "#FFCC00" }
    ]);

    // 获取数据
    const fetchData = async () => {
      try {
        loading.value = true;
        error.value = null;

        // 并发请求两个接口
        const [classResponse, educationResponse] = await Promise.all([
          getStudentCountData(),
          getStudentDegreeData(),
        ]);

        // 处理班级数据
        if (classResponse.code == 1) {
          classData.value = classResponse.data;

          totalStudents.value =
            classData.value.dataList?.reduce((sum, num) => sum + num, 0) || 0;
          maxClassSize.value =
            classData.value.dataList?.length > 0
              ? Math.max(...classData.value.dataList)
              : 0;
        } else {
          throw new Error(classResponse.data.msg || "班级数据加载失败");
        }

        // 处理学历数据
        if (educationResponse.code == 1) {
          educationData.value = educationResponse.data;

          highestEducation.value = educationData.value.reduce(
            (max, item) => (item.value > max.value ? item : max),
            educationData.value[0] || { value: 0 }
          );

          // 初始化学历图表
          nextTick(() => {
            if (eduChartContainer.value) {
              initEduChart();
            } else {
              setTimeout(() => {
                if (eduChartContainer.value) initEduChart();
                else console.error("延迟后仍未找到学历图表容器");
              }, 100);
            }
          });
        } else {
          throw new Error(educationResponse.data.msg || "学历数据加载失败");
        }

        // 初始化班级图表
        nextTick(() => {
          if (classChartContainer.value) {
            initClassChart();
          } else {
            setTimeout(() => {
              if (classChartContainer.value) initClassChart();
              else console.error("延迟后仍未找到班级图表容器");
            }, 100);
          }
        });
      } catch (err) {
        error.value = err.message || "数据加载失败";
        console.error("数据加载错误:", err);
      } finally {
        loading.value = false;
      }
    };

    // 初始化班级图表
    const initClassChart = () => {
      if (!classChartContainer.value) {
        console.error("班级图表容器未找到");
        return;
      }

      try {
        if (classChartInstance) {
          classChartInstance.dispose();
        }

        classChartInstance = window.echarts.init(classChartContainer.value);

        const displayNames = classData.value.clazzList.map((name) =>
          name === null ? "未知班级" : name
        );

        const option = {
          tooltip: {
            trigger: "axis",
            backgroundColor: "rgba(255, 255, 255, 0.95)",
            borderColor: "#ddd",
            borderWidth: 1,
            textStyle: {
              color: "#333",
            },
            formatter: function (params) {
              return `${params[0].name}<br/>人数: ${params[0].value}`;
            },
          },
          grid: {
            left: "3%",
            right: "4%",
            bottom: "10%",
            containLabel: true,
          },
          xAxis: {
            type: "category",
            data: displayNames,
            axisLine: {
              lineStyle: {
                color: "#ccc",
              },
            },
            axisLabel: {
              color: "#666",
              interval: 0,
              rotate: 30,
              formatter: function (value) {
                return value.length > 10
                  ? value.substring(0, 8) + "..."
                  : value;
              },
            },
          },
          yAxis: {
            type: "value",
            name: "人数",
            nameTextStyle: {
              color: "#666",
            },
            min: 0,
            max: Math.max(...classData.value.dataList) * 1.2,
            axisLine: {
              show: true,
              lineStyle: {
                color: "#ccc",
              },
            },
            splitLine: {
              lineStyle: {
                color: "#eee",
              },
            },
          },
          series: [
            {
              name: "班级人数",
              type: "bar",
              data: classData.value.dataList,
              itemStyle: {
                color: function (params) {
                  const colors = [
                    "#5470c6",
                    "#91cc75",
                    "#fac858",
                    "#ee6666",
                    "#73c0de",
                  ];
                  return colors[params.dataIndex % colors.length];
                },
              },
              label: {
                show: true,
                position: "top",
                color: "#333",
              },
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowColor: "rgba(0, 0, 0, 0.5)",
                },
              },
            },
          ],
        };

        classChartInstance.setOption(option);
      } catch (err) {
        console.error("班级图表初始化失败:", err);
        error.value = "班级图表初始化失败";
      }
    };

    // 初始化学历图表
    const initEduChart = () => {
      if (!eduChartContainer.value) {
        console.error("学历图表容器未找到");
        return;
      }

      try {
        if (eduChartInstance) {
          eduChartInstance.dispose();
        }

        eduChartInstance = window.echarts.init(eduChartContainer.value);

        const option = {
          tooltip: {
            trigger: "item",
            formatter: "{b}: {c} ({d}%)"
          },
          series: [
            {
              name: "学历分布",
              type: "pie",
              radius: ["40%", "70%"],
              data: educationData.value,
              label: {
                show: false
              },
              labelLine: {
                show: true
              }
            }
          ]
        };

        eduChartInstance.setOption(option);
      } catch (err) {
        console.error("学历图表初始化失败:", err);
        error.value = "学历图表初始化失败";
      }
    };

    // 响应窗口大小变化
    const handleResize = () => {
      if (classChartInstance) {
        classChartInstance.resize();
      }
      if (eduChartInstance) {
        eduChartInstance.resize();
      }
    };

    onMounted(() => {
      import("echarts")
        .then((echarts) => {
          window.echarts = echarts;
          console.log("ECharts加载完成，开始拉取数据");
          fetchData();
        })
        .catch((err) => {
          console.error("ECharts加载失败:", err);
          error.value = "图表库加载失败";
          loading.value = false;
        });
      window.addEventListener("resize", handleResize);
    });

    onUnmounted(() => {
      if (classChartInstance) {
        classChartInstance.dispose();
      }
      if (eduChartInstance) {
        eduChartInstance.dispose();
      }
      window.removeEventListener("resize", handleResize);
    });

    return {
      educationData,
      classData,
      classChartContainer,
      eduChartContainer,
      totalStudents,
      highestEducation,
      maxClassSize,
      loading,
      error,
      fetchData,
      educationLegend
    };
  },
};
</script>

<style scoped>
.class-statistics {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  font-family: "Arial", sans-serif;
  color: #333;
}

.header {
  text-align: center;
  margin-bottom: 30px;
  padding: 25px;
  background: linear-gradient(90deg, #3498db, #2c3e50);
  color: white;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.header h1 {
  font-size: 28px;
  margin-bottom: 8px;
  font-weight: 600;
}

.subtitle {
  font-size: 16px;
  opacity: 0.9;
}

.dashboard-content {
  display: flex;
  flex-direction: column;
  gap: 30px;
}

/* 新增：图表行布局 */
.chart-row {
  display: flex;
  gap: 20px;
  margin-bottom: 40px;
  /* 让行在垂直方向上优先占据空间 */
  align-items: flex-start; 
  /* 强制行的最小高度，防止被下方挤压 */
  min-height: 350px; 
}

.chart-col {
  flex: 1;
  /* 强制每列宽度为50%，确保左右等分 */
  width: 50%; 
  /* 防止内容溢出导致宽度变化 */
  box-sizing: border-box; 
}

.chart-card {
  background: white;
  border-radius: 12px;
  padding: 20px;
  width: 100%;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.chart-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.chart-header h2 {
  font-size: 20px;
  color: #2c3e50;
  font-weight: 500;
}

.chart-legend {
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
}

.legend-item {
  display: flex;
  align-items: center;
  gap: 6px;
  font-size: 12px;
  color: #666;
}

.color-dot {
  width: 10px;
  height: 10px;
  border-radius: 50%;
}

.blue {
  background-color: #5470c6;
}

.chart {
  width: 100%;
  /* 最小高度确保图表不被挤没，最大高度限制过度拉伸 */
  min-height: 350px; 
  max-height: 450px;
  height: auto;
}

.summary-section {
  background: white;
  border-radius: 12px;
  padding: 25px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.summary-section h3 {
  font-size: 20px;
  color: #2c3e50;
  margin-bottom: 20px;
  text-align: center;
  font-weight: 500;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 20px;
}

.stat-card {
  text-align: center;
  padding: 20px;
  background: linear-gradient(135deg, #f5f7fa 0%, #e4efe9 100%);
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

.stat-icon {
  font-size: 32px;
  margin-bottom: 10px;
}

.stat-value {
  font-size: 28px;
  font-weight: bold;
  color: #3498db;
  margin-bottom: 5px;
}

.stat-label {
  color: #7f8c8d;
  font-size: 14px;
}

.loading-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 60px;
  text-align: center;
}

.loader {
  width: 50px;
  height: 50px;
  border: 5px solid #f3f3f3;
  border-top: 5px solid #3498db;
  border-radius: 50%;
  animation: spin 1s linear infinite;
  margin-bottom: 20px;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

.error-container {
  text-align: center;
  padding: 40px;
  background-color: #ffebee;
  border-radius: 8px;
}

.error-icon {
  font-size: 48px;
  margin-bottom: 16px;
  color: #e53935;
}

.error-container h2 {
  color: #c62828;
  margin-bottom: 10px;
}

.error-container p {
  color: #555;
  margin-bottom: 20px;
}

.retry-btn {
  background-color: #3498db;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  transition: background-color 0.3s;
}

.retry-btn:hover {
  background-color: #2980b9;
}

@media (max-width: 768px) {
  .chart-col {
    width: 100%; /* 垂直堆叠时宽度占满 */
  }
}
</style>