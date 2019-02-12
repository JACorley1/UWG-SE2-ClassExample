'''
Created on Feb 12, 2019

@author: jcorley
'''
import unittest

from model.recipe import Recipe

class TestConstructor(unittest.TestCase):
    
    def testNameIsNone(self):
        with self.assertRaises(Exception):
            Recipe(None, ['pasta', 'italian'], 1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], 2)
    
    def testCategoriesIsNone(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", None, 1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], 2)
    
    def testIngredientsIsNone(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian'], 1.0, 2.0, None, ['combine ingredients', 'cook ingredients'], 2)
    
    def testInstructionsIsNone(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian'], 1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], None, 2)
    
    def testCategoriesContainsNone(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian', None], 1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], 2)
    
    def testIngredientsContainsNone(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian'], 1.0, 2.0, ['meat', 'noodles', None, 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], 2)
    
    def testInstructionsContainsNone(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian'], 1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], [None, 'combine ingredients', 'cook ingredients'], 2)
    
    def testTimeToCookIsNegative(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian'], -1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], 2)
    
    def testTimeToPrepIsNegative(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian'], 1.0, -1.0, ['meat', 'noodles', 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], 2)
    
    def testServingsIsNegative(self):
        with self.assertRaises(Exception):
            Recipe("Lasagna", ['pasta', 'italian'], 1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], -1)
    
    def testCreateValidRecipe(self):
        result = Recipe("Lasagna", ['pasta', 'italian'], 1.0, 2.0, ['meat', 'noodles', 'sauce', 'cheese'], ['combine ingredients', 'cook ingredients'], 3)
        
        self.assertEqual("Lasagna", result.getName(), "checking name")
        self.assertEqual(2, len(result.getCategories()), "checking number of categories")
        self.assertEqual("pasta", result.getCategories()[0], "checking first category")
        self.assertEqual("italian", result.getCategories()[1], "checking second category")
        
        self.assertEqual(4, len(result.getIngredients()), "checking number of ingredients")
        self.assertEqual("meat", result.getIngredients()[0], "checking first ingredient")
        self.assertEqual("noodles", result.getIngredients()[1], "checking second ingredient")
        self.assertEqual("sauce", result.getIngredients()[2], "checking third ingredient")
        self.assertEqual("cheese", result.getIngredients()[3], "checking fourth ingredient")
        
        self.assertEqual(2, len(result.getInstructions()), "checking number of instructions")
        self.assertEqual("combine ingredients", result.getInstructions()[0], "checking first instruction")
        self.assertEqual("cook ingredients", result.getInstructions()[1], "checking second instruction")
        
        self.assertEqual(1.0, result.getTimeToCook(), "checking time to cook")
        
        self.assertEqual(2.0, result.getTimeToPrep(), "checking time to prep")
        
        self.assertEqual(3, result.getServings(), "checking number of servings")

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()