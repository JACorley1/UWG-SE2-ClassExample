'''
Created on Feb 14, 2019

@author: jcorley
'''
from request_server import constants

class RecipeRequestHandler:
    '''
    Manages the collection of recipes stored by the server
    '''


    def __init__(self):
        '''
        Loads the set of recipes stored by the server.
        '''
        self._recipes = []
        
        recipe1 = {}
        recipe1["name"] = "lasagna"
        recipe1["categories"] = ["pasta", "italian"]
        recipe1["prepTime"] = 1.0
        recipe1["cookTime"] = 2.0
        recipe1["ingredients"] = ["meat", "noodles", "sauce", "cheese"]
        recipe1["instructions"] = ["Combine ingredients", "Cook ingredients"]
        recipe1["servings"] = 2
        self._recipes.append(recipe1);
        
        recipe2 = {}
        recipe2["name"] = "eggplant parmesan"
        recipe2["categories"] = ["pasta", "italian", "vegetarian"]
        recipe2["prepTime"] = 3.0
        recipe2["cookTime"] = 4.0
        recipe2["ingredients"] = ["eggplant", "noodles", "sauce", "cheese"]
        recipe2["instructions"] = ["Combine ingredients", "Cook ingredients"]
        recipe2["servings"] = 5
        self._recipes.append(recipe2);
        
    def _loadRecipes(self):
        '''
            Returns a response with a standard success code (1) and the collection of all recipes stored by the server.
        '''
        response = {} 
        response[constants.KEY_STATUS] = constants.SUCCESS_STATUS
        response[constants.KEY_RECIPES] = self._recipes
        
        return response
    
    def handleRequest(self, request):
        '''
            Parses out the request type, and distributes processing to the appropriate helper to handle the request.
            See individual helper method for description of how each request type is handled.
            
            Supported request types:
                load_recipes
        '''
        response = {constants.KEY_STATUS:constants.UNSUPPORTED_OPERATION_STATUS, constants.KEY_FAILURE_MESSAGE:"unsupported request type"}
        
        if(request[constants.KEY_REQUEST_TYPE] == constants.LOAD_RECIPES_REQUEST_TYPE):
            response = self._loadRecipes()
        
        return response
        