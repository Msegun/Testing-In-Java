
Scenario: Dodawanie a i b
Given Mam utworzony nowy kalkulator
When dodam liczby 5i5
Then po dodaniu dostane 10


Scenario: Odejmowanie a i b

Given Mam utworzony kolejny kalkulator
When Odejmuje liczby 5i5
Then po dodaniu dostane 0

Scenario: Mnozenie a i b

Given Mam utworzony kolejny kalkulator
When mnoze liczby 5i5
Then po mnozeniu dostane 25

Scenario: Dzielenie a i b

Given Mam utworzony kolejny kalkulator
When dziele liczby 1i10
Then po dzieleniu dostane 0.1

Scenario: Wiekszy a i b

Given Mam utworzony nowy kalkulator
When Sprawdzam wiekszy 1i10
Then po greater dostane false

Scenario: Mnozenie 2 i 5
Given Mam utworzony kolejny kalkulator
When mnoze liczby <value1> i <value2>
Then po mnozeniu dostane <resultValue>

Examples:     
|value1|value2|resultValue|
|2|5|10|


Scenario: Mnozenie a i b
After : fail
After : success
Given Mam utworzony kolejny kalkulator
When mnoze liczby 5i5
Then po mnozeniu dostane 25
