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
POST http://localhost:9000/api/devices/: Retrieves all devices.</br>
GET http://localhost:9000/api/devices/{id}: Retrieves a specific device by ID.</br>
POST http://localhost:9000/api/devices: Adds a new device.</br>
POST http://localhost:9000/api/predict/{deviceId}: Predicts the price and updates the device entity.

### Data Storage
PostgresSQL

### Setup and Execution
Open the demo project in IntelliJ IDEA or a similar IDE.
Please Note That you have to install PostgreSQL First and make sure that the database is listening on port 5432, and creat database called called `device_price_classification` 
Run the application.


## Contributions
Contributions are welcome. Please submit pull requests for review.

