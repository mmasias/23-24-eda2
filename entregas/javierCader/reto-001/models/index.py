from structures.list import CustomList
class Food: 
    def __init__(self, name: str):
        self.name = name

class Intake: 
    def __init__(self, type: str):
        self.type = type
        self.foods = []

    def add_food(self, food: Food):
        self.foods.append(food)

class Day: 
    def __init__(self, number: int):
        self.number = number
        self.intakes = [Intake("Breakfast"), Intake("Mid-morning"), Intake("Lunch"), Intake("Snack"), Intake("Dinner")]

class Survey:
    def __init__(self):
        self.days = [Day(i) for i in range(1, 7)]

class Patient:
    def __init__(self, name: str, discharge_date: str):
        self.name = name
        self.discharge_date = discharge_date
        self.surveys = []

    def add_survey(self, survey: Survey):
        self.surveys.append(survey)
