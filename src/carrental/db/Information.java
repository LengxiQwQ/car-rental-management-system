package carrental.db;

public class Information {
        // 定义和表字段对应的属性
        private String name;
        private int age;

        // 构造方法
        public Information(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter和Setter方法（右键→Insert Code→Getter and Setter）
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }

