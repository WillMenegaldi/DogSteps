package br.com.dogsteps.models.dto;

public class PasseioDto {
    private String dogwalkerId;
    private String tutorId;

    public PasseioDto(String dogwalkerId, String tutorId){
        setDogwalkerId(dogwalkerId);
        setTutorId(tutorId);
    }

    public String getDogwalkerId() {
        return dogwalkerId;
    }
    public void setDogwalkerId(String dogwalkerId) {
        this.dogwalkerId = dogwalkerId;
    }

    public String getTutorId() {
        return tutorId;
    }
    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    PasseioDto(){}
}
