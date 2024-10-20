import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class Bill {
    String date;
    double amount;
    String category;
    String remark;
    String type; // "income" or "expense"
    public Bill(String date, double amount, String category, String remark, String type) {
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.remark = remark;
        this.type = type;
    }
}
public class PersonalBillingSystem {
    private static List<Bill> bills = new ArrayList<>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
            System.out.println("3. 查看所有账单");
            System.out.println("4. 账单查询");
            System.out.println("5. 退出系统");
            System.out.print("请输入选项序号：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    recordIncome(scanner);
                    break;
                case 2:
                    recordExpense(scanner);
                    break;
                case 3:
                    viewAllBills();
                    break;
                case 4:
                    searchBills(scanner);
                    break;
                case 5:
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效输入，请重新选择。");
            }
            System.out.println("按任意键返回主菜单...");
            scanner.nextLine(); // Wait for user input to return to menu
        }
    }
    private static void recordIncome(Scanner scanner) {
        System.out.println("请输入收入信息：");
        System.out.print("日期（YYYY-MM-DD）：");
        String date = scanner.nextLine();
        System.out.print("金额：");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("类别（如工资、奖金等）：");
        String category = scanner.nextLine();
        System.out.print("备注：");
        String remark = scanner.nextLine();
        bills.add(new Bill(date, amount, category, remark, "income"));
        System.out.printf("收入已成功记录！\n");
    }
    private static void recordExpense(Scanner scanner) {
        System.out.println("请输入支出信息：");
        System.out.print("日期（YYYY-MM-DD）：");
        String date = scanner.nextLine();
        System.out.print("金额：");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("类别（如购物、餐饮等）：");
        String category = scanner.nextLine();
        System.out.print("备注：");
        String remark = scanner.nextLine();
        bills.add(new Bill(date, amount, category, remark, "expense"));
        System.out.printf("支出已成功记录！\n");
    }
    private static void viewAllBills() {
        System.out.println("所有账单记录：");
        System.out.println("收入：");
        for (Bill bill : bills) {
            if ("income".equals(bill.type)) {
                System.out.printf("日期：%s, 金额：%.2f, 类别：%s, 备注：%s\n", bill.date, bill.amount, bill.category, bill.remark);
            }
        }
        System.out.println("支出：");
        for (Bill bill : bills) {
            if ("expense".equals(bill.type)) {
                System.out.printf("日期：%s, 金额：%.2f, 类别：%s, 备注：%s\n", bill.date, bill.amount, bill.category, bill.remark);
            }
        }
    }
    private static void searchBills(Scanner scanner) {
        System.out.println("请选择查询方式：");
        System.out.println("1. 按日期查询");
        System.out.println("2. 按日期范围查询");
        System.out.println("3. 按类别查询");
        System.out.print("请输入选项序号：");
        int searchType = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (searchType) {
            case 1:
                searchByDate(scanner);
                break;
            case 2:
                searchByDateRange(scanner);
                break;
            case 3:
                searchByCategory(scanner);
                break;
            default:
                System.out.println("无效输入，请重新选择。");
        }
    }
    private static void searchByDate(Scanner scanner) {
        System.out.print("请输入查询日期（YYYY-MM-DD）：");
        String date = scanner.nextLine();
        try {
            Date queryDate = sdf.parse(date);
            System.out.println("收入：");
            for (Bill bill : bills) {
                if ("income".equals(bill.type) && sdf.format(sdf.parse(bill.date)).equals(date)) {
                    System.out.printf("日期：%s, 金额：%.2f, 类别：%s, 备注：%s\n", bill.date, bill.amount, bill.category, bill.remark);
                }
            }
            System.out.println("支出：");
            for (Bill bill : bills) {
                if ("expense".equals(bill.type) && sdf.format(sdf.parse(bill.date)).equals(date)) {
                    System.out.printf("日期：%s, 金额：%.2f, 类别：%s, 备注：%s\n", bill.date, bill.amount, bill.category, bill.remark);
                }
            }
        } catch (ParseException e) {
            System.out.println("日期格式错误，请使用YYYY-MM-DD格式。");
        }
    }
    private static void searchByDateRange(Scanner scanner) {
        System.out.print("请输入开始日期（YYYY-MM-DD）：");
        String startDateStr = scanner.nextLine();
        System.out.print("请输入结束日期（YYYY-MM-DD）：");
        String endDateStr = scanner.nextLine();
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            System.out.println("收入：");
            for (Bill bill : bills) {
                if ("income".equals(bill.type) && !sdf.format(sdf.parse(bill.date)).before(startDateStr) && !sdf.format(sdf.parse(bill.date)).after(endDateStr)) {
                    System.out.printf("日期：%s, 金额：%.2f, 类别：%s, 备注：%s\n", bill.date, bill.amount, bill.category, bill.remark);
                }
            }
            System.out.println("支出：");
            for (Bill bill : bills) {
                if ("expense".equals(bill.type) && !sdf.format(sdf.parse(bill.date)).before(startDateStr) && !sdf.format(sdf.parse(bill.date)).after(endDateStr)) {
                    System.out.printf("日期：%s, 金额：%.2f, 类别：%s, 备注：%s\n", bill.date, bill.amount, bill.category, bill.remark);
                }
            }
        } catch (ParseException e) {
            System.out.println("日期格式错误，请使用YYYY-MM-DD格式。");
        }
    }