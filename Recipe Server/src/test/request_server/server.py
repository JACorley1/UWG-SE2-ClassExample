'''
Created on Feb 14, 2019

@author: jcorley
'''
import unittest, zmq, json, time
from threading import Thread
from request_server import server, constants

class TestServer(unittest.TestCase):


    def setUp(self):
        serverThread = Thread(target=server.main, args=(constants.PROTOCOL, constants.IP_ADDRESS, constants.PORT,))
        serverThread.start()
        time.sleep(1)
        context = zmq.Context()
        self._socket = context.socket(zmq.REQ)
        serverLocation = "{0}://{1}:{2}".format(constants.PROTOCOL, constants.IP_ADDRESS, constants.PORT)
        self._socket.connect(serverLocation)

    def tearDown(self):
        self._socket.send_string(json.dumps("exit"))


    def testLoadRecipes(self):
        request = {constants.KEY_REQUEST_TYPE:constants.LOAD_RECIPES_REQUEST_TYPE}
        jsonRequest = json.dumps(request)
        
        self._socket.send_string(jsonRequest)
        
        jsonResponse = self._socket.recv_string()
        response = json.loads(jsonResponse)
        
        
        recipes = []
        
        recipe1 = {}
        recipe1["name"] = "lasagna"
        recipe1["categories"] = ["pasta", "italian"]
        recipe1["prepTime"] = 1.0
        recipe1["cookTime"] = 2.0
        recipe1["ingredients"] = ["meat", "noodles", "sauce", "cheese"]
        recipe1["instructions"] = ["Combine ingredients", "Cook ingredients"]
        recipe1["servings"] = 2
        recipes.append(recipe1);
        
        recipe2 = {}
        recipe2["name"] = "eggplant parmesan"
        recipe2["categories"] = ["pasta", "italian", "vegetarian"]
        recipe2["prepTime"] = 3.0
        recipe2["cookTime"] = 4.0
        recipe2["ingredients"] = ["eggplant", "noodles", "sauce", "cheese"]
        recipe2["instructions"] = ["Combine ingredients", "Cook ingredients"]
        recipe2["servings"] = 5
        recipes.append(recipe2);
        
        self.assertEqual(constants.SUCCESS_STATUS, response[constants.KEY_STATUS], "checking status of response")
        self.assertEqual(recipes, response[constants.KEY_RECIPES], "checking recipes")


    def testNoRequestType(self):
        request = ""
        jsonRequest = json.dumps(request)
        
        self._socket.send_string(jsonRequest)
        
        jsonResponse = self._socket.recv_string()
        response = json.loads(jsonResponse)
        
        self.assertEqual(constants.BAD_MESSAGE_STATUS, response[constants.KEY_STATUS], "checking status of response")


    def testUnsupportedRequestType(self):
        request = {constants.KEY_REQUEST_TYPE:-33}
        jsonRequest = json.dumps(request)
        
        self._socket.send_string(jsonRequest)
        
        jsonResponse = self._socket.recv_string()
        response = json.loads(jsonResponse)
        
        self.assertEqual(constants.UNSUPPORTED_OPERATION_STATUS, response[constants.KEY_STATUS], "checking status of response")

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()