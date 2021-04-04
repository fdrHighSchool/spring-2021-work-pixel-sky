import java.util.ArrayList;
import java.util.List;

class LogMessage {
    private String machineId;
    private String description;

    public LogMessage(String message) {
        int colonIndex = message.indexOf(":");
        this.machineId = message.substring(0, colonIndex);
        this.description = message.substring(colonIndex+1, message.length());
    }

    public boolean containsWords(String keyword) {
        for (String word : this.description.split(" ")) {
            if (word.matches(keyword))
                return true;
        }
        return false;
    }

    public String getMachineId() {
        return this.machineId;
    }

    public String getDescription() {
        return this.description;
    }
}

class SystemLog {
    private List<LogMessage> messageList;

    public List<LogMessage> removeMessages(String keyword) {
        List<LogMessage> removedMessages = new ArrayList<LogMessage>();
        for (int i = 0; i < this.messageList.size(); i++) {
            if (this.messageList.get(i).containsWords(keyword)) {
                removedMessages.add(this.messageList.remove(i));
            }
        }
        return removedMessages;
    }
}