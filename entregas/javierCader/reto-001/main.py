from controllers.index import Clinic_Controller
from factories.index import PatientFactory
from models.index import Survey
from structures.list import CustomList

class Clinic:
    def __init__(self):
        self.patients = CustomList()
        self.patient_factory = PatientFactory()

    def receive_patient(self):
        patient = self.patient_factory.create_patient("Jose Manuel R.", "2021-01-24")
        self.patients.append(patient)
        return patient

    def run_clinic(self):
        patient = self.receive_patient()
        survey = Survey()
        patient.add_survey(survey)

        controller = Clinic_Controller(self.patients, patient)
        controller.run()


if __name__ == "__main__":
    clinic = Clinic()
    clinic.run_clinic()
