package fr.eni.filmotheque.bo;

public class Opinion {
    private Long id;
    private int note;
    private String comment;
    private Member member;

    public Opinion() {
    }

    public Opinion(Long id, int note, String comment, Member member) {
        this.id = id;
        this.note = note;
        this.comment = comment;
        this.member = member;
}

    public Opinion(int note, String comment, Member member) {
        this.note = note;
        this.comment = comment;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Opinion{");
        sb.append("id=").append(id);
        sb.append(", note=").append(note);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", member=").append(member);
        sb.append('}');
        return sb.toString();
    }
}
