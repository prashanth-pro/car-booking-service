The service is deployed in Azure. The base url of the REST API is https://cars-booking-service.azuremicroservices.io

API Spec can be found at https://cars-booking-service.azuremicroservices.io/swagger-ui/index.html

## How to test the car booking service 

        (OR)

## Steps to book a car for a particular time period 

To book a car for given timeperiod we need the following records in the database

2. Car
3. Location
3. Customer

Step 1: Create Location record

HTTP Method: POST

URL: https://cars-booking-service.azuremicroservices.io/locations

Request Body:
```json
{
  "id": 0,
  "name": "string"
}
```
Step 2: Create customer record

HTTP Method: POST

URL: https://cars-booking-service.azuremicroservices.io/customers

Request Body:
```json
{
  "id": 0,
  "name": "string",
  "email": "string",
  "phoneNumber": "string"
}
```

Step 3: Create car record

HTTP Method: POST

URL: https://cars-booking-service.azuremicroservices.io/cars

Request Body:
```json
{
  "id": 0,
  "brand": "string",
  "model": "string",
  "location": {
    "id": 0,
    "name": "string"
  }
}
```

## How to do the booking of a car

Booking requires following details

1. Who is booking the car
2. Which car is being booked
3. For which location
4. What is the pickup time and drop time

Successful booking will have booking id and status as SUCCESS

HTTP Method: POST

URL: https://cars-booking-service.azuremicroservices.io/bookings

Request Body:

```json
{
    "customer_id": 1,
    "car_id": 1,
    "pickupTime" : "2022-10-07 05:30:00",
    "dropTime" : "2022-10-08 05:30:00",
    "location_id" : 1
}
```