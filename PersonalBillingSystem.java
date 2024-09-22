import java.util.Scanner;
// 定义个人账单管理系统类
public class PersonalBillingSystem {
    // 构造函数，当前为空实现，但可用于初始化操作（如果有的话）
    public PersonalBillingSystem() {
    }
    // 主函数，程序的入口点
    public static void main(String[] args) {
        // 创建Scanner对象用于接收用户输入
        Scanner scanner = new Scanner(System.in);
        // 使用无限循环来保持系统持续运行，直到用户选择退出
        while(true) {
            // 显示系统欢迎信息和操作选项
            System.out.println("=================================");
            System.out.println("欢迎使用个人账单管理系统");
            System.out.println("=================================");
            System.out.println("请选择操作：");
            System.out.println("1. 记录收入");
            System.out.println("2. 记录支出"); // 注意：此功能尚未实现
            System.out.println("3. 退出系统");
            System.out.print("请输入选项序号：");
            // 读取用户输入的选择
            int choice = scanner.nextInt();
            // 消耗nextInt()后的换行符，避免影响后续nextLine()的读取
            scanner.nextLine();
            // 根据用户的选择执行相应的操作
            switch (choice) {
                case 1:
                    // 调用记录收入的方法
                    recordIncome(scanner);
                    break;
                case 2:
                    // 通知用户记录支出功能尚未实现
                    System.out.println("记录支出功能尚未实现。");
                    break;
                case 3:
                    // 用户选择退出，显示感谢信息，关闭scanner并退出程序
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return;
                default:
                    // 用户输入了无效选项，提示重新选择
                    System.out.println("无效输入，请重新选择。");
            }
            // 提示用户按任意键返回主菜单，并读取用户的输入（仅用于等待用户按键）
            System.out.println("按任意键返回主菜单...");
            scanner.nextLine();
        }
    }
    // 定义一个静态方法用于记录收入信息
    private static void recordIncome(Scanner scanner) {
        // 提示用户输入收入信息的各个部分
        System.out.println("请输入收入信息：");
        System.out.print("日期（YYYY-MM-DD）：");
        String date = scanner.nextLine(); // 读取日期
        System.out.print("金额：");
        double amount = scanner.nextDouble(); // 读取金额
        scanner.nextLine(); // 消耗nextDouble()后的换行符
        System.out.print("类别（如工资、奖金等）：");
        String category = scanner.nextLine(); // 读取类别
        System.out.print("备注：");
        String remark = scanner.nextLine(); // 读取备注
        // 输出用户输入的收入信息
        System.out.printf("收入已成功记录！\n日期：%s\n金额：%.2f\n类别：%s\n备注：%s\n", date, amount, category, remark);
    }
}