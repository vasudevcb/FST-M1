"""userName = input("Enter your username")
print("Username is: " + userName)
userAge = int(input("Enter your age"))
print("Your age is: "+ str(userAge))
year = str((2023 - userAge) + 100)
print( userName + " will be 100 years old in the year " + year )
"""
# To print age in txt where you cannot combine the string
age = 40
txt = "My age is {}"
print(txt.format(age))

example_list = ["apple","orange","mango"]
example_list1 = list(("apple","orange","mango"))
print(example_list)
print(example_list1)
example_list.sort()
print(example_list)
example_list.insert(1,"banana")
print(example_list)
example_list.pop(1)
print(example_list)
print("length of string-value: " + str(len(example_list)))


""" numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
sum1 = 0
for number in numbers:
    sum1 = sum1 + int(number)
    print(sum1) """

# tuples
example_tuple_list = ("orange", "Mango", "banana")
for i in example_tuple_list:
    print(i)

# tuples constructor
example_tuple_range = tuple(("orange", "mango", "banana", "banana"))
print(example_tuple_range)

example_sets = {"mango", "banana", "orange"}
print(example_sets)
example_sets.add("orange1")
print(example_sets)

# dictionaries
example_dict ={
    "brand": "Ford",
    "model": "Mustang",
    "year": 1964
}
print(example_dict)

x=example_dict["model"]
print(x)

def myfunction():
    print("message from function")

myfunction()

def my_name(name):
    print("My name is " +name)
my_name("Sri Ganesh")

# to send multiple paramater which is unknown
def my_unlimit(*name):
    print("My name is :" +name[0] +name[1])
my_unlimit("Om","Ganesh")

def my_returnval(x=5):
    return 5*x

print(my_returnval(6))
print(my_returnval())

# Calculate the sum of numbers
# using recursion
def sum(n):
    if n <= 1:
        return n
    else:
        return n + sum(n-1)

num = int(input("Enter a number: "))
print("The sum is: ", sum(num))