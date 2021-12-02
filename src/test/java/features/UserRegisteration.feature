Feature: User Registeration
	I want to check that the user can register to our e-commerce website.
	
	Scenario Outline: User Registeration
	Given the user in the home page
	When I click in register link
	And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>" 
	Then The Registeration page displayed successfully
	 
	Examples:
 	 | firstname | lastname | email | password |
 	 | ahmed | mohamed | ahmed11@user434.com | 12345678 |
 	 | Moataz | ahmed | test11@newuser233.com | 87654321 |

