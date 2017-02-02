# Problem : Sort Hotel List
Given a set of hotels and its guests reviews, sort the hotels based on a list of words specified by a user. The criteria to sort the hotels should be how many time the words specified by the user is mentioned.

### Input:
The first line contains a space-separated set of words which we want to find mentions in the hotel reviews.
The second line contains one integer M, which is the number of reviews.
This is followed by M+M lines, which alternates an hotel ID and a review belonging to that hotel.

### Output:
A list of hotel IDs sorted, in descending order, by how many mentions they have of the words specified in the input.

### Notes:
* The wordss to be find will always be single words like 'breakfast' or 'noise'. Never double words like 'swimming pool'.
* Hotel ID is a 4-byte integer
* Words match should be case-insensitive
* Dots and commas should be ignored.
* If a word appears in a review twice, it should count twice.
* If two hotels have the same number of mentions, they should be sorted in the output based on their ID, smallest ID first.
* In case one or more test cases time out, consider revisiting the runtime complexity of your algorithms.

### Sample Output:
```
breakfast beach citycenter location metro view staff price
5
1
This hotel has a nice view of the citycenter. The location is perfect
2
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
1
Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
1
They said I couldn't take my dog and there were other guests with dogs! That is not fair.
2
Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.
```

### Sample Output:
```
2 1
```

### Explanation:
Hotel *2* has 7 mentions of the words: "location" and "citycenter" are mentioned twice while "breakfast", "price", and "staff" are mentioned once. Hotel *1* in the other hand has 6 mentions in total "location" and "citycenter" also twice and then "view" and "metro" once.

# Solution
Refer 
```
HotelSortForGuest.java file
```