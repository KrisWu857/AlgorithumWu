//package com.itkris.demo1;
//
//import java.util.Scanner;
//
//public class Test4 {
//    public class Student {
//        private String name;
//        private String gender;
//        private boolean isClassMonitor;
//        private double mathScore;
//        private double chineseScore;
//        private double foreignLanguageScore;
//
//        public Student(String name, String gender, boolean isClassMonitor, double mathScore, double chineseScore, double foreignLanguageScore) {
//            this.name = name;
//            this.gender = gender;
//            this.isClassMonitor = isClassMonitor;
//            this.mathScore = mathScore;
//            this.chineseScore = chineseScore;
//            this.foreignLanguageScore = foreignLanguageScore;
//        }
//
//        public double calculateTotalScore() {
//            return mathScore + chineseScore + foreignLanguageScore;
//        }
//
//        public double calculateAverageScore() {
//            return calculateTotalScore() / 3;
//        }
//
//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("请输入学生姓名: ");
//            String name = scanner.nextLine();
//
//            System.out.print("请输入学生性别: ");
//            String gender = scanner.nextLine();
//
//            System.out.print("该学生是否是班干部 (true/false): ");
//            boolean isClassMonitor = scanner.nextBoolean();
//
//            System.out.print("请输入数学成绩: ");
//            double mathScore = scanner.nextDouble();
//
//            System.out.print("请输入语文成绩: ");
//            double chineseScore = scanner.nextDouble();
//
//            System.out.print("请输入外语成绩: ");
//            double foreignLanguageScore = scanner.nextDouble();
//
//            Student student = new Student(name, gender, isClassMonitor, mathScore, chineseScore, foreignLanguageScore);
//
//
//            double totalScore = student.calculateTotalScore();
//            double averageScore = student.calculateAverageScore();
//
//            System.out.println("\n学生信息:");
//            System.out.println("姓名: " + student.name);
//            System.out.println("性别: " + student.gender);
//            System.out.println("班干部: " + (student.isClassMonitor ? "是" : "否"));
//            System.out.println("数学成绩: " + student.mathScore);
//            System.out.println("语文成绩: " + student.chineseScore);
//            System.out.println("外语成绩: " + student.foreignLanguageScore);
//            System.out.println("总分: " + totalScore);
//            System.out.println("平均分: " + averageScore);
//        }
//    }
//
//}
