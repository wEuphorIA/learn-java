package com.itheima.d2_enum;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 上午9:59 */
public class Demo3 {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("请输入移动位置：");
        // int direction = scanner.nextInt();
        //move(direction);
        move(Direction.UP);
    }

    // private static void move(int direction) {
    //     switch (direction){
    //         case Constant.DIRECTION_UP:
    //             System.out.println("向上移动");
    //             break;
    //         case Constant.DIRECTION_DOWN:
    //             System.out.println("向下移动");
    //             break;
    //         case Constant.DIRECTION_LEFT:
    //             System.out.println("向左移动");
    //             break;
    //         case Constant.DIRECTION_RIGHT:
    //             System.out.println("向右移动");
    //             break;
    //         default:
    //             System.out.println("无效的移动位置");
    //     }
    // }

        private static void move(Direction direction) {
            switch (direction){
                case UP:
                    System.out.println("向上移动");
                    break;
                case DOWN:
                    System.out.println("向下移动");
                    break;
                case LEFT:
                    System.out.println("向左移动");
                    break;
                case RIGHT:
                    System.out.println("向右移动");
                    break;
            }
        }
}
