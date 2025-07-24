package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午4:27
 */
/*
    break和continue关键字：
        break关键字：写在循环或者switch语句中，用于结束所在循环或者switch分支。
        continue关键字：只能写在循环中，用于跳过本次循环，继续下一个循环。
    //需求1：假如你跟别的姑娘搭汕被你女朋友撞见了，女朋友很生气，你为了哄她向她说了5句”我爱你”说到第三句的时候她她火气更大，让你别再说了。
    //需求2：假如你跟别的姑娘搭汕被你女朋友撞见了，女朋友很生气，她罚你做5天俯卧撑，在第三天的时候，由于你表现很好，她说今天不用做了，明天继续。
 */
public class Demo17 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("今天不用俯卧撑");
                continue;
            }
            System.out.println("今天开始做俯卧撑" + i);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("我爱你");
            if (i == 3) {

                break;
            }
        }
    }
}
