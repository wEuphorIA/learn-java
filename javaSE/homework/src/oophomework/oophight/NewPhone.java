package oophomework.oophight;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/25 下午11:50
 */
public class NewPhone extends OldPhone implements IPlay{
    @Override
    public void playGame() {
        System.out.println("新手机可以玩游戏");
    }
    @Override
    public void call() {
        System.out.println("新手机可以打电话");
    }

    @Override
    public void sendMessage() {
        System.out.println("新手机可以发短信");
    }
}
