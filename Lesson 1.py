def calculate_total_height(users):
    total = 0

    for user in users:
        total += user["height"]

    return total


users = []

for i in range(2):
    print(f"\nEnter details for User {i + 1}")

    # Name validation
    while True:
        name = input("Enter your name: ").strip()

        if name:
            break
        else:
            print("Ensure Name is provided. Please try again.")

    # Age validation
    while True:
        try:
            age = int(input("Enter your age: "))

            if age > 0:
                break
            else:
                print("Age must be greater than 0.")

        except ValueError:
            print("Please enter a valid number for age.")

    # Height validation
    while True:
        try:
            height = float(input("Enter your height in cm: "))

            if height > 0:
                break
            else:
                print("Height must be greater than 0.")

        except ValueError:
            print("Please enter a valid number for height.")

    user = {
        "name": name,
        "age": age,
        "height": height
    }

    users.append(user)


print("\nUser Information:")

for user in users:
    print(f"{user['name']} is {user['age']} years old and {user['height']} cm")


total_height = calculate_total_height(users)

print(f"\nTotal combined height: {total_height} cm")