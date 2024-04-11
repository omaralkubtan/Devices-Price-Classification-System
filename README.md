# Devices Price Classification System

This project builds a Devices Price Classification System using Python and Spring Boot. The system includes two small projects:

## Python Project

The Python project predicts the prices, allowing the sellers to classify the device's prices according to their characteristics.

### Dataset

The dataset includes device specifications with the following columns:

- id
- battery_power
- blue
- clock_speed
- dual_sim
- fc
- four_g
- int_memory
- m_dep
- mobile_wt
- n_cores
- pc
- px_height
- px_width
- ram
- sc_h
- sc_w
- talk_time
- three_g
- touch_screen
- wifi
- price_range

The `price_range` is the target variable with values of 0 (low cost), 1 (medium cost), 2 (high cost), and 3 (very high cost).

### Running the Python Project

To run the Python project:
First you have to active the virtual environment by run the activate.bin in the /python/env/Scripts 
then navigate to the `env` folder and run the `classifier_rout.py` file using the command:

```bash
python classifier_rout.py

to view AI python code you can find it in the notebook file "device_price_classification.ipynb"
you can find the code documented there 

Spring Boot Project
The Spring Boot project contains a simple entity and a few endpoints to call the service from the Python project for a bunch of test cases and store them.

Entities
Device: Describes every device in our system.
Endpoints
● POST http://localhost:9000/api/devices/: Retrieve a list of all devices
● GET  http://localhost:9000/api/devices/{id}: Retrieve details of a specific device by ID.
● POST http://localhost:9000/api/devices: Add a new device.
● POST http://localhost:9000/api/predict/{deviceId} This will call the Python API to predict the price, and save the result in the device entity here.

and to run the spring project you have to open it from ide like (intellij ) and press run 








# Devices Price Classification System

## Overview
The Devices Price Classification System is an AI-powered application designed to predict the price range of electronic devices based on their specifications. It integrates a Python-based machine learning model with a Spring Boot application to provide a seamless user experience.

## Python Project

### Features
- Utilizes a robust machine learning model to classify devices into price ranges.
- Processes device specifications such as battery power, Bluetooth availability, and more.

### Dataset
The dataset columns include:
- **id**: Unique identifier for each device.
- **battery_power**: Battery capacity in mAh.
- **blue**: Bluetooth support (Yes/No).
- **clock_speed**: Processor speed.
- **dual_sim**: Dual SIM support (Yes/No).
- **fc**: Front camera megapixels.
- **four_g**: 4G support (Yes/No).
- **int_memory**: Internal memory in GB.
- **m_dep**: Mobile depth in cm.
- **mobile_wt**: Mobile weight.
- **n_cores**: Number of processor cores.
- **pc**: Primary camera megapixels.
- **px_height**: Pixel resolution height.
- **px_width**: Pixel resolution width.
- **ram**: RAM in MB.
- **sc_h**: Screen height in cm.
- **sc_w**: Screen width in cm.
- **talk_time**: Maximum talk time.
- **three_g**: 3G support (Yes/No).
- **touch_screen**: Touchscreen support (Yes/No).
- **wifi**: WiFi support (Yes/No).
- **price_range**: Target variable (0: low cost, 1: medium cost, 2: high cost, 3: very high cost).

### Running the Project
1. Activate the virtual environment:
   ```bash
   source /python/env/Scripts/activate

Run the classifier:
python classifier_rout.py

For AI code and documentation, refer to device_price_classification.ipynb.

## Spring Boot Project

### Entities
Device: Represents the details of each device.

### Endpoints
POST http://localhost:9000/api/devices/: Retrieves all devices.
GET http://localhost:9000/api/devices/{id}: Retrieves a specific device by ID.
POST http://localhost:9000/api/devices: Adds a new device.
POST http://localhost:9000/api/predict/{deviceId}: Predicts the price and updates the device entity.

### Setup and Execution
Open the demo project in IntelliJ IDEA or a similar IDE.
Please Note That you have to install PostgreSQL First and make sure that the database is listening on port 5432, and creat database called called `device_price_classification` 
Run the application.

### Data Storage
PostgresSQL

Contributions
Contributions are welcome. Please submit pull requests for review.

