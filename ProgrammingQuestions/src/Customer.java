class Customer {
    private String name;
    private int age;
    private String city;

    // Constructor
    public Customer(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    // toString for displaying the object
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", city='" + city + "'}";
    }
}