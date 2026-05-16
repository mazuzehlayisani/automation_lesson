import requests
import json


def get_api_data(url):
    response = requests.get(url)

    if response.status_code == 200:
        return response.json()
    else:
        print("Failed to fetch data:", response.status_code)
        return None


def save_to_json(data, filename):
    with open(filename, "w") as file:
        json.dump(data, file, indent=4)
    print(f"Data successfully saved to {filename}")


# API endpoint
url = "https://www.ndosiautomation.co.za/APIDEV/groups"

# Step 1: Get data from API
api_data = get_api_data(url)

# Step 2: Save to file
if api_data:
    save_to_json(api_data, "groups.json")