from models.index import Patient, Day, Intake, Food
from views.index import View

class Clinic_Controller:
    def __init__(self, patients: list, patient: Patient):
        self.patients = patients
        self.patient = patient
        self.is_running = True 

    def run(self):
        while self.is_running:
            View.display_header("Day Selection")
            day_number = self.select_day(self.patient)
            if day_number == -1:
                self.is_running = False
                continue
            elif day_number == -2:
                View.print_patient_data(self.patient)
                continue
            elif day_number == -3:
                self.delete_day(self.patient)
                continue
            elif day_number == -4:
                self.add_day(self.patient)
                continue

            if 1 <= day_number <= len(self.patient.surveys[0].days):
                selected_day: Day = self.patient.surveys[0].days[day_number - 1]
                View.display_header(f"Intake Selection for {selected_day.number}")
                while True:
                    intake_number = self.select_intake(selected_day)
                    if intake_number == -1:
                        break 
                    elif intake_number == -2:
                        View.print_patient_data(self.patient) 
                        continue  
                    elif intake_number == -3:
                        self.delete_intake(selected_day)
                        continue
                    elif intake_number == -4:
                        self.add_intake(selected_day)
                        continue

                    if 1 <= intake_number <= len(selected_day.intakes):
                        selected_intake = selected_day.intakes[intake_number - 1]
                        self.add_food(selected_intake)

        View.display_header("Exit")
        View.print_patient_data(self.patient) 
        print(View.BOLD + "Exiting the application." + View.ENDC)

    def select_day(self, patient: Patient) -> int:
        View.display_prompt(f"Patient: {patient.name} / To exit enter -1 / To list all data enter -2 / To delete a day enter -3 / To add a day enter -4")
        for day in patient.surveys[0].days:
            print(f"Day {day.number}")
        return self.get_validated_input("Enter day number: ", len(patient.surveys[0].days))
    
    def add_day(self, patient: Patient):
        day_number = len(patient.surveys[0].days) + 1
        day = Day(day_number)
        patient.surveys[0].days.append(day)
        print(f"Day {day_number} has been added.")
    
    def delete_day(self, patient: Patient):
        day_to_delete = int(input("Enter the day number you want to delete: "))
        patient.surveys[0].days.pop(day_to_delete - 1)
        print(f"Day {day_to_delete} has been deleted.")

    def select_intake(self, day: Day) -> int:
        View.display_prompt("Select intake: / To exit enter -1 / To list all data enter -2 / To delete an intake enter -3 / To add an intake enter -4")
        for i, intake in enumerate(day.intakes):
            print(f"{i + 1}. {intake.type}")
        return self.get_validated_input("Enter number: ", len(day.intakes))
    
    def add_intake(self, day: Day):
        intake_type = input("Enter intake type: ")
        intake = Intake(intake_type)
        day.intakes.append(intake)
        
    def delete_intake(self, day: Day):
        intake_to_delete = int(input("Enter the intake number you want to delete: "))
        day.intakes.pop(intake_to_delete - 1)
        print(f"Intake {intake_to_delete} has been deleted.")

    def get_validated_input(self, prompt: str, max_value: int) -> int:
        while True:
            try:
                user_input = int(input(prompt))
                if -4 <= user_input <= max_value:
                    return user_input
                else:
                    print(f"Please enter a valid number between 1 and {max_value}.")
            except ValueError:
                print("Invalid input. Please enter a number.")

    def add_food(self, intake: Intake):
        while True:
            food_name = self.ask_for_food(intake)
            if food_name == "-1":
                break
            elif food_name == "-2":
                View.print_foods(intake)
            elif food_name == "-3":
                self.delete_food(intake)
            elif food_name == "-4":
                self.update_food(intake)
            else:
                food = Food(food_name)
                intake.add_food(food)
                
    def delete_food(self, intake: Intake):
        food_to_delete = int(input("Enter the food number you want to delete: "))
        intake.foods.pop(food_to_delete - 1)
        print(f"Food {food_to_delete} has been deleted.")
        
    def update_food(self, intake: Intake):
        food_to_update = int(input("Enter the food number you want to update: "))
        new_food_name = input("Enter the new food name: ")
        intake.foods[food_to_update - 1].name = new_food_name
        print(f"Food {food_to_update} has been updated.")

    def ask_for_food(self, intake: Intake):
        return input(f"{View.BOLD}Input a food for {intake.type} (-1 to exit / -2 to list the foods / -3 to delete a food / -4 to update a food): {View.ENDC}")
