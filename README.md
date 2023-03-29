# Animal Registration System RESTful API

This project is a simple RESTful web service for an animal registration system. It allows users to store and manage registration data of animals, including the date, weight, registration number, and origin (farm). The API provides endpoints for adding, retrieving, and filtering animals based on various criteria.

## Features

- Add a new animal with its details.
- Retrieve an animal's details by its registration number.
- List all animals registered in the system.
- Filter animals by their registration date.
- Filter animals by their origin (farm).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- Maven
- Git

### Installing

1. Clone the repository

2. Go to the project directory

3. Build the project

4. Run the application


The application will start on port 8080 by default.

## Usage

You can use any REST client (e.g., Postman) to send HTTP requests to the API endpoints.

### Add a new animal

POST /api/animals

```json
{
  "registrationNumber": "A12345",
  "origin": "Farm A",
  "registrationDate": "2023-03-22",
  "weight": 450
}


- Retrieve an animal's details
GET /api/animals/{registrationNumber}

- List all animals
GET /api/animals

- Filter animals by registration date
GET /api/animals?registrationDate=2023-03-22

- Filter animals by origin
GET /api/animals?origin=Farm%20A
