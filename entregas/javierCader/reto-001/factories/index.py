
from models.index import Patient

class PatientFactory:
    @staticmethod
    def create_patient(name, discharge_date):
        return Patient(name, discharge_date)
