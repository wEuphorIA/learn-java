package oophomework.oophight;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/25 下午11:51
 */
public class PhoneTest {
    public static void main(String[] args) {
        // 测试旧手机
        OldPhone oldPhone = new OldPhone();
        oldPhone.call();         // 输出: 普通地打电话功能
        oldPhone.sendMessage();  // 输出: 普通地发短信功能

        // 测试新手机
        NewPhone newPhone = new NewPhone();
        newPhone.call();         // 输出: 新手机视频通话
        newPhone.sendMessage();  // 输出: 新手机发送语音和图片
        newPhone.playGame();     // 输出: 新手机可以玩游戏
    }
}
