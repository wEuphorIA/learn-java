<template>
  <div class="employee-dashboard">
    <div class="header">
      <h1>员工数据统计面板</h1>
      <p class="subtitle">基于部门提供的员工数据分析</p>
    </div>

    <div class="dashboard-content">
      <div class="chart-section">
        <div class="chart-card">
          <h2 class="chart-title">员工职位统计</h2>
          <div ref="jobChartRef" class="chart"></div>
        </div>
        
        <div class="chart-card">
          <h2 class="chart-title">员工性别统计</h2>
          <div ref="genderChartRef" class="chart"></div>
        </div>
      </div>
      
      <div class="summary-section">
        <h3>统计摘要</h3>
        <div class="stats-grid">
          <div class="stat-item">
            <div class="stat-value">{{ totalEmployees }}</div>
            <div class="stat-label">员工总数</div>
          </div>
          <div class="stat-item">
            <div class="stat-value">{{ maxJob.count }}</div>
            <div class="stat-label">{{ maxJob.name }}人数</div>
          </div>
          <div class="stat-item">
            <div class="stat-value">{{ maleCount }}</div>
            <div class="stat-label">男性员工</div>
          </div>
          <div class="stat-item">
            <div class="stat-value">{{ femaleCount }}</div>
            <div class="stat-label">女性员工</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, onUnmounted } from 'vue';
import * as echarts from 'echarts/dist/echarts.esm.js'; // 修改后的导入方式

export default {
  name: 'EmployeeDashboard',
  setup() {
    const jobChartRef = ref(null);
    const genderChartRef = ref(null);
    let jobChart = null;
    let genderChart = null;
    
    // 模拟数据
    const jobData = ref([
      { name: '教研主管', value: 1 },
      { name: '学工主管', value: 1 },
      { name: '其他', value: 5 },
      { name: '班主任', value: 8 },
      { name: '咨询师', value: 10 },
      { name: '讲师', value: 13 }
    ]);
    
    const genderData = ref([
      { name: '男性员工', value: 12 },
      { name: '女性员工', value: 8 }
    ]);
    
    const totalEmployees = ref(jobData.value.reduce((sum, item) => sum + item.value, 0));
    const maxJob = ref({
      name: jobData.value.reduce((max, item) => item.value > max.value ? item : max, jobData.value[0]).name,
      count: jobData.value.reduce((max, item) => item.value > max.value ? item : max, jobData.value[0]).value
    });
    const maleCount = ref(genderData.value.find(item => item.name === '男性员工')?.value || 0);
    const femaleCount = ref(genderData.value.find(item => item.name === '女性员工')?.value || 0);
    
    // 初始化图表
    const initCharts = () => {
      // 职位统计柱状图
      if (jobChartRef.value) {
        jobChart = echarts.init(jobChartRef.value);
        jobChart.setOption({
          tooltip: {
            trigger: 'axis',
            backgroundColor: 'rgba(255, 255, 255, 0.9)',
            borderColor: '#eee',
            borderWidth: 1,
            textStyle: {
              color: '#333'
            },
            formatter: function(params) {
              return `${params[0].name}<br/>人数: ${params[0].value}`;
            }
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '10%',
            containLabel: true
          },
          xAxis: {
            type: 'category',
            data: jobData.value.map(item => item.name),
            axisLine: {
              lineStyle: {
                color: '#ccc'
              }
            },
            axisLabel: {
              color: '#666',
              interval: 0,
              rotate: 30
            }
          },
          yAxis: {
            type: 'value',
            name: '人数',
            nameTextStyle: {
              color: '#666'
            },
            axisLine: {
              show: true,
              lineStyle: {
                color: '#ccc'
              }
            },
            splitLine: {
              lineStyle: {
                color: '#eee'
              }
            }
          },
          series: [{
            name: '员工人数',
            type: 'bar',
            data: jobData.value.map(item => item.value),
            itemStyle: {
              color: function(params) {
                const colors = ['#5470c6', '#91cc75', '#fac858', '#ee6666', '#73c0de', '#3ba272'];
                return colors[params.dataIndex % colors.length];
              }
            },
            label: {
              show: true,
              position: 'top',
              color: '#333'
            },
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }]
        });
      }
      
      // 性别统计环形图
      if (genderChartRef.value) {
        genderChart = echarts.init(genderChartRef.value);
        genderChart.setOption({
          tooltip: {
            trigger: 'item',
            backgroundColor: 'rgba(255, 255, 255, 0.9)',
            borderColor: '#eee',
            borderWidth: 1,
            textStyle: {
              color: '#333'
            },
            formatter: function(params) {
              return `${params.name}: ${params.value}人 (${params.percent}%)`;
            }
          },
          legend: {
            orient: 'horizontal',
            bottom: 10,
            data: genderData.value.map(item => item.name)
          },
          series: [{
            name: '员工性别',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: true,
              formatter: '{b}: {c}人\n({d}%)'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '14',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: true
            },
            data: genderData.value.map((item, index) => ({
              value: item.value,
              name: item.name,
              itemStyle: {
                color: index === 0 ? '#3498db' : '#2ecc71'
              }
            }))
          }]
        });
      }
    };
    
    // 响应窗口大小变化
    const handleResize = () => {
      if (jobChart) jobChart.resize();
      if (genderChart) genderChart.resize();
    };
    
    onMounted(() => {
      initCharts();
      window.addEventListener('resize', handleResize);
    });
    
    onUnmounted(() => {
      if (jobChart) jobChart.dispose();
      if (genderChart) genderChart.dispose();
      window.removeEventListener('resize', handleResize);
    });
    
    return {
      jobChartRef,
      genderChartRef,
      totalEmployees,
      maxJob,
      maleCount,
      femaleCount
    };
  }
};
</script>

<style scoped>
.employee-dashboard {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  font-family: 'Arial', sans-serif;
  color: #333;
}

.header {
  text-align: center;
  margin-bottom: 30px;
  padding: 20px;
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

.chart-section {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(400px, 1fr));
  gap: 20px;
}

.chart-card {
  background: white;
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.chart-title {
  font-size: 20px;
  color: #2c3e50;
  margin-bottom: 15px;
  font-weight: 500;
  text-align: center;
}

.chart {
  height: 350px;
  width: 100%;
}

.summary-section {
  background: white;
  border-radius: 12px;
  padding: 20px;
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
  gap: 15px;
}

.stat-item {
  text-align: center;
  padding: 20px;
  background: linear-gradient(135deg, #f5f7fa 0%, #e4efe9 100%);
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

.stat-value {
  font-size: 32px;
  font-weight: bold;
  color: #3498db;
  margin-bottom: 5px;
}

.stat-label {
  color: #7f8c8d;
  font-size: 14px;
}

@media (max-width: 768px) {
  .chart-section {
    grid-template-columns: 1fr;
  }
  
  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
  }
  
  .stat-value {
    font-size: 24px;
  }
}
</style>