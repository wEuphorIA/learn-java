package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午4:04
 */
public class Demo15 {
    public static void main(String[] args) {
        // 佛祖图案的字符数组
        String[] buddha = {
                "                   _ooOoo_",
                "                  o8888888o",
                "                  88\" . \"88",
                "                  (| -_- |)",
                "                  O\\  =  /O",
                "               ____/`---'\\____",
                "             .'  \\|     |//  `.   ",
                "            /  \\|||  :  |||//  \\  ",
                "           /  _||||| -:- |||||-  \\ ",
                "           |   | \\\\  -  /// |   |",
                "           | \\_|  ''\\---/''  |   |",
                "           \\  .-\\__  `-`  ___/-. /",
                "         ___`. .'  /--.--\\  `. . __",
                "      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".",
                "     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |",
                "     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /",
                "======`-.____`-.___\\_____/___.-`____.-'======",
                "                   `=---='",
                "",
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^",
                "         佛祖保佑       永无BUG"
        };

        // 遍历并打印佛祖图案
        for (String line : buddha) {
            System.out.println(line);
        }
    }
}