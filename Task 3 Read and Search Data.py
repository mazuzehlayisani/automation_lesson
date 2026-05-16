import json


def read_file(filename):
    with open(filename, "r") as file:
        return json.load(file)


def search_group(data, group_name):

    # Step 1: get the actual list
    groups = data.get("data", [])

    # Step 2: search inside list
    for group in groups:
        if group.get("Name", "").strip().lower() == group_name.strip().lower():
            return group

    return None

#Accessing data and searching the group

filename = "groups.json"
data = read_file(filename)

search_name = input("Enter group name to search: ").strip()

result = search_group(data, search_name)

if result:
    print(f"Success! Group found. ID: {result.get('Id')}")
else:
    print("Error: Group not found.")