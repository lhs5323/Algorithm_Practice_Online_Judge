import java.util.*;
public class AgeSort{
  static class Member implements Comparable<Member>{
    int age;
    String name;
    Member(int age, String name){
      this.name = name;
      this.age = age;
    }
    @Override
    public int compareTo(Member m){
      return this.age - m.age;
    }

    public String getName(){
      return this.name;
    }
    public int getAge(){
      return this.age;
    }
  }
  public static void main(String[] args){
    List<Member> log = new ArrayList<Member>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int i = 0; i < n; i++){
      int age = sc.nextInt();
      String name = sc.next();
      //Member person = new Member();

      Member person = new Member(age, name);
      log.add(person);
    }
    Collections.sort(log);
    for(Member member : log){
      System.out.println(member.getAge() + " " + member.getName());
    }
  }
}
