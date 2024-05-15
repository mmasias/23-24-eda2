from models.index import Patient, Day, Intake, Food
from views.index import View
from structures.list import CustomList

class Clinic_Controller:
    def __init__(self, patients: CustomList, patient: Patient):
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

            if 1 <= day_number <= 5:
                selected_day = self.patient.surveys[0].days[day_number - 1]
                View.display_header(f"Intake Selection for {selected_day}")
                while True:
                    intake_number = self.select_intake(selected_day)
                    if intake_number == -1:
                        break 
                    elif intake_number == -2:
                        View.print_patient_data(self.patient) 
                        continue  

                    if 1 <= intake_number <= len(selected_day.intakes):
                        selected_intake = selected_day.intakes[intake_number - 1]
                        self.add_food(selected_intake)

        View.display_header("Exit")
        View.print_patient_data(self.patient) 
        print(View.BOLD + "Exiting the application." + View.ENDC)

    def select_day(self, patient: Patient) -> int:
        View.display_prompt(f"Patient: {patient.name} / To exit enter -1 / To list all data enter -2")
        for day in patient.surveys[0].days:
            print(f"Day {day.number}")
        return self.get_validated_input("Enter day number: ", len(patient.surveys[0].days))

    def select_intake(self, day: Day) -> int:
        View.display_prompt("Select intake: / To exit enter -1 / To list all data enter -2")
        for i, intake in enumerate(day.intakes):
            print(f"{i + 1}. {intake.type}")
        return self.get_validated_input("Enter number: ", len(day.intakes))

    def get_validated_input(self, prompt: str, max_value: int) -> int:
        while True:
            try:
                user_input = int(input(prompt))
                if -2 <= user_input <= max_value:
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
            else:
                food = Food(food_name)
                intake.add_food(food)

    def ask_for_food(self, intake: Intake):
        return input(f"{View.BOLD}Input a food for {intake.type} (-1 to exit / -2 to list the foods): {View.ENDC}")
