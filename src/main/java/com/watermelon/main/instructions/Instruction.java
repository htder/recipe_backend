package com.watermelon.main.instructions;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "instructions")
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String instructionText;
    private Integer instructionPosition;

    public Instruction() {}

    public Instruction(
            String instructionText,
            Integer instructionPosition
    ) {
        this.instructionText = instructionText;
        this.instructionPosition = instructionPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long instructionId) {
        this.id = instructionId;
    }

    public String getInstructionText() {
        return instructionText;
    }

    public void setInstructionText(String instruction) {
        this.instructionText = instruction;
    }

    public Integer getInstructionPosition() {
        return instructionPosition;
    }

    public void setInstructionPosition(Integer order) {
        this.instructionPosition = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return Objects.equals(id, that.id) && Objects.equals(instructionText, that.instructionText) && Objects.equals(instructionPosition, that.instructionPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instructionText, instructionPosition);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", instructionText='" + instructionText + '\'' +
                ", instructionPosition=" + instructionPosition +
                '}';
    }
}