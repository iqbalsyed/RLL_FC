@Updateaddress
Feature: Update Address
  User wants to update Address

  Scenario Outline: Update and Verify Address
    Given Open up Fc Website and add Login Details
    #When Login using emailid
    Then Click the Profile
    Then click and Add address as per "<location>"
    Then Verify address is saved

    Examples: 
      | location                         |
      | testdata\\\\Address.xlsx         |
      
      
       #testdata\\\\emptyname.xlsx       
       #testdata\\\\emptypincode.xlsx    
       #testdata\\\\emptyflat.xlsx       
     
       #testdata\\\\emptystreet.xlsx     
       #testdata\\\\sevencharstreet.xlsx 
       #testdata\\\\randompincode.xlsx   
       #testdata\\\\onewordname.xlsx    
       #testdata\\\\sevencharflat.xlsx  