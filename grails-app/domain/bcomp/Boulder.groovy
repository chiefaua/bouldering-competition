package bcomp

class Boulder {

    static constraints = {
        grade blank: false
    }

    static belongsTo = [section: Section]

    String grade

}
