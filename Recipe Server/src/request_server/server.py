'''
Created on Feb 14, 2019

@author: jcorley
'''
import sys
import zmq
import json
from request_server.recipe_request_handler import RecipeRequestHandler

def log(message):
    print("SERVER::{0}".format(message))

def main(protocol, ipAddress, port):
    recipeRequestHandler = RecipeRequestHandler()
    
    context = zmq.Context()
    socket = context.socket(zmq.REP)
    socket.bind("{0}://{1}:{2}".format(protocol, ipAddress, port))
    
    while True:
        #  Wait for next request from client
        log("waiting for request...")
        json_message = socket.recv_string()
        request = json.loads(json_message)
        log("Received request: {0}".format(request))
        if("request_type" not in request):
            socket.send_string({"success_code":-1, "failure_message":"no request type"})
        elif(request['request_type'] == "exit"):
            return
        else:
            response = recipeRequestHandler.handleRequest(request)
            json_response = json.dumps(response)
            socket.send_string(json_response)

if (__name__ == "__main__"):
    #main(sys.argv[1], sys.argv[2], sys.argv[3])
    main("tcp", "127.0.0.1", "5555")