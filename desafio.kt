enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome: String, var sobrenome: String, val cpf: String) {
    val formacoesInscritas = mutableListOf<String>()
    
    fun addNovaFormacao(formacao: String) {
        formacoesInscritas.add(formacao)
    }
    
    fun listarFormacoes() {
        println("Formações que o usuário $nome se inscreveu: ")
        formacoesInscritas.forEach{
            formacao -> println("$formacao ")
        }
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        usuario.addNovaFormacao(this.nome)
    }
    
    fun listarInscritos() {
        println("Inscritos na Formação $nome: ")
    	inscritos.forEach{
    		inscrito -> println("${inscrito.nome}")
        }
    }
}

fun main() {
    val conteudoKotlinUm = ConteudoEducacional("Conhecendo Kotlin e Sua Documentação Oficial")
    val conteudoKotlinDois = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin")
    val conteudosKotlin: List<ConteudoEducacional> = mutableListOf(conteudoKotlinUm, conteudoKotlinDois)
    val formacaoKotlin = Formacao("Kotlin", conteudosKotlin, Nivel.INTERMEDIARIO)
    
    val conteudoJavaUm = ConteudoEducacional("Conhecendo Java e Sua Documentação Oficial")
    val conteudoJavaDois = ConteudoEducacional("Introdução Prática à Linguagem de Programação Java")
    val conteudoJavaTres = ConteudoEducacional("Trabalhando com Collections")
    val conteudosJava: List<ConteudoEducacional> = mutableListOf(conteudoJavaUm, conteudoJavaDois, conteudoJavaTres)
    val formacaoJava = Formacao("Java", conteudosJava, Nivel.DIFICIL)
    
    val usuario1 = Usuario("Joao","Maria","000.111.222-33")
    val usuario2 = Usuario("Felipe","Carvalho","001.111.222-33")
    val usuario3 = Usuario("Pedro","Rosa","002.111.222-33")
    
    println("---------------------------")
    
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    
    formacaoKotlin.listarInscritos()
    
    usuario1.listarFormacoes()
    usuario2.listarFormacoes()
    usuario3.listarFormacoes()
    
    println("---------------------------")
    
    formacaoJava.matricular(usuario1)
    formacaoJava.matricular(usuario2)
    formacaoJava.matricular(usuario3)
    
    formacaoJava.listarInscritos()
    
    usuario1.listarFormacoes()
    usuario2.listarFormacoes()
    usuario3.listarFormacoes()
    
    println("---------------------------")

}
