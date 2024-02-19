package model;

import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AverageOutput {
    Set<Character> vowels;
    Integer length;
    Double average;

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("({");
        vowels.forEach(vowel -> sb.append(vowel).append(","));
        sb.delete(sb.length() - 1, sb.length());
        sb.append("}").append(", ").append(length).append(")");
        sb.append(" -> ").append(average);
        sb.append("\n");
        return sb.toString();
    }
}
