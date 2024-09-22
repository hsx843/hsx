import java.util.Scanner;
public class PersonalBillingSystem {
    public PersonalBillingSystem() {
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=================================");
            System.out.println("欢迎使用个人账单管理系统");
            System.out.println("=================================");
            System.out.println("请选择操作：");
            System.out.println("1. 记录收入");
            System.out.println("2. 记录支出");
            System.out.println("3. 退出系统");
            System.out.print("请输入选项序号：");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    recordIncome(scanner);
                    break;
                case 2:
                    System.out.println("记录支出功能尚未实现。");
                    break;
                case 3:
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效输入，请重新选择。");
            }
            System.out.println("按任意键返回主菜单...");
            scanner.nextLine();
        }
    }
    private static void recordIncome(Scanner scanner) {
        System.out.println("请输入收入信息：");
        System.out.print("日期（YYYY-MM-DD）：");
        String date = scanner.nextLine();
        System.out.print("金额：");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("类别（如工资、奖金等）：");
        String category = scanner.nextLine();
        System.out.print("备注：");
        String remark = scanner.nextLine();
        System.out.printf("收入已成功记录！\n日期：%s\n金额：%.2f\n类别：%s\n备注：%s\n", date, amount, category, remark);
    }
}