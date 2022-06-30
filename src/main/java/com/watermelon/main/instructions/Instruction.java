package com.watermelon.main.instructions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Instruction {

    @Id
    private Long instructionId;
    private String instruction;

    public Instruction() {}

    public Instruction(String instruction) {
        this.instruction = instruction;
    }

    public Long getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(Long instructionId) {
        this.instructionId = instructionId;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return Objects.equals(instructionId, that.instructionId) && Objects.equals(instruction, that.instruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionId, instruction);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "instructionId=" + instructionId +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
