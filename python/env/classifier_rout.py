from flask import Flask, jsonify, request
import joblib

classifier = joblib.load('model.pkl')

# List of feature names that your model was trained on
feature_names =['batteryPower', 'blue', 'clockSpeed', 'dualSim', 'fourG', 'intMemory', 'mdep', 'mobileWt', 'ncores', 'pc', 'pxHeight','ram', 'scW', 'talkTime', 'threeG', 'touchScreen', 'wifi']

app = Flask(__name__)

@app.route('/api/predict', methods=['POST'])
def predict():
    data = request.get_json()
    print(data, '\n')
    
     # Select only the features that your model was trained on
    features = [data[feature] for feature in feature_names]
    prediction = classifier.predict([features])
    print('prediction ',  prediction.tolist()[0], '\n')
    return jsonify({'prediction': prediction.tolist()[0]})

if __name__ == '__main__':
    app.run(port=5000, debug=True)