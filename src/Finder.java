import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {
    public Set<String> findOldMembers(List<MembersGroup> groups, int targetAge) {
        Set<String> groupsNames = new HashSet<>();

        // Рефакторинг кода с применением stream.api
        groups.stream()
                .map(membersGroup -> membersGroup.getMembers())
                .flatMap(group -> group.stream())
                .filter(members -> members.getAge() > targetAge)
                .forEach(member -> groupsNames.add(member.getName()));

        // Исходный код
        /*for (MembersGroup membersGroup : groups) {
            for (Member member : membersGroup.getMembers()) {
                if (member.getAge() > targetAge) {
                    String name = member.getName();
                    groupsNames.add(name);
                }
            }
        }
        */
        return groupsNames;
    }
}