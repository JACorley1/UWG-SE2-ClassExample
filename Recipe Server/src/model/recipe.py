'''
Created on Feb 12, 2019

@author: jcorley
'''

class Recipe:
    '''
    Stores basic information for a recipe.
    '''

    def __init__(self, name, categories, timeToCook, timeToPrep, ingredients, instructions, servings):
        ''' 
            Create a new recipe with the provided information.
            
            @precondition name != None && 
                          categories != None && !categories.contains(None) &&
                          timeToCook >= 0.0 && 
                          timeToPrep >= 0.0 && 
                          ingredients != None &&  !ingredients.contains(None) &&
                          instructions != None &&  !instructions.contains(None) &&
                          servings >= 0
            
            @postcondition getName() == name &&
                           getCategories() == categories &&
                           getTimeToCook() == timeToCook &&
                           getTimeToPrep() == timeToPrep &&
                           getIngredients() == ingredients &&
                           getInstructions() == instructions &&
                           getServings() == servings
            
            @param name name for the recipe
            @param timeToCook time to cook for the recipe
            @param timeToPrep time to prep for the recipe
            @param categories list of categories for the recipe
            @param ingredients list of ingredients for the recipe
            @param instructions list of instructions for the recipe
            @param servings number of people the recipe serves
        '''
        if (name == None):
            raise Exception("name is None")
        
        if (categories == None):
            raise Exception("categories is None")
        if (None in categories):
            raise Exception("categories contains None")
        
        if (ingredients == None):
            raise Exception("ingredients is None")
        if (None in ingredients):
            raise Exception("ingredients contains None")
        
        if (instructions == None):
            raise Exception("instructions is None") 
        if (None in instructions):
            raise Exception("instructions contains None")
        
        if (timeToCook < 0):
            raise Exception("time to cook is negative")
        
        if (timeToPrep < 0):
            raise Exception("time to prep is negative")
        
        if (servings < 0):
            raise Exception("number of servings is negative")
       
        self._name = name
        self._categories = categories
        self._timeToCook = timeToCook
        self._timeToPrep = timeToPrep
        self._ingredients = ingredients
        self._instructions = instructions
        self._servings = servings
    
    def getName(self):
        ''' 
            Returns the name of the recipe
        
            @precondition none
            @postcondition none
            
            @return the name of the recipe
        '''
        return self._name
    
    def getTimeToCook(self):
        ''' 
            Returns the time to cook of the recipe
        
            @precondition none
            @postcondition none
            
            @return the time to cook of the recipe
        '''
        return self._timeToCook
    
    def getTimeToPrep(self):
        ''' 
            Returns the time to prep of the recipe
        
            @precondition none
            @postcondition none
            
            @return the time to prep of the recipe
        '''
        return self._timeToPrep
    
    def getCategories(self):
        ''' 
            Returns the categories of the recipe
        
            @precondition none
            @postcondition none
            
            @return the categories of the recipe
        '''
        return self._categories
    
    def getIngredients(self):
        ''' 
            Returns the ingredients of the recipe
        
            @precondition none
            @postcondition none
            
            @return the ingredients of the recipe
        '''
        return self._ingredients
    
    def getInstructions(self):
        ''' 
            Returns the instructions of the recipe
        
            @precondition none
            @postcondition none
            
            @return the instructions of the recipe
        '''
        return self._instructions
    
    def getServings(self):
        ''' 
            Returns the number of servings of the recipe
        
            @precondition none
            @postcondition none
            
            @return the number of servings of the recipe
        '''
        return self._servings