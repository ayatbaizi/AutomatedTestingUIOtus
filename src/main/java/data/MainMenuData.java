package data;

public enum MainMenuData {
   Cources("Курсы");

   private String name;

   MainMenuData(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}
