import java.util.List;

class ContactDetails {
   private String email_id;
   private long phone_number;
   private String address;

   ContactDetails(String email_id, long phone_number, String address) {
      this.email_id = email_id;
      this.phone_number = phone_number;
      this.address = address;
   }
}

class Applicants {
   public String applicant_name;
   public int years_exp;
   public ContactDetails contact;

   void setName(String applicant_name) {
      this.applicant_name = applicant_name;
   }

   String getName(String applicant_name) {
      return applicant_name;
   }

   void setYears(int years_exp) {
      this.years_exp = years_exp;
   }

   int getYears(int years_exp) {
      return years_exp;
   }

   void setContact(ContactDetails contact) {
      this.contact = contact;
   }

   ContactDetails getContact(ContactDetails contact) {
      return contact;
   }

   Applicants(String applicant_name, int years_exp, ContactDetails contact) {
      this.applicant_name = applicant_name;
      this.years_exp = years_exp;
      this.contact = contact;
   }
}

class Industry {
   private String industry_name;
   private List<Applicants> applicants;

   void setName(String industry_name) {
      this.industry_name = industry_name;
   }

   String getName(String industry_name) {
      return industry_name;
   }

   void setApplicant(List<Applicants> applicants) {
      this.applicants = applicants;
   }

   List<Applicants> getApplicant(List<Applicants> applicants) {
      return applicants;
   }

   Industry(String industry_name, List<Applicants> applicants) {
      this.industry_name = industry_name;
      this.applicants = applicants;
   }
}

public class example {
   public static void main(String[] args) {
   }
}