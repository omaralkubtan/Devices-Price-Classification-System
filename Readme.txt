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