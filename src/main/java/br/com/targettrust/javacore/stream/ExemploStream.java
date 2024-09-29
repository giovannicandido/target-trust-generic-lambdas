package br.com.targettrust.javacore.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExemploStream {
    private ClienteRepository clienteRepository;
    public void processarArquivoCliente(String[] args) {
        String userHome = System.getProperty("user.home");
        List<String> informacoesCliente;
        try {
             informacoesCliente = Files.readAllLines(Path.of(Paths.get(userHome) + File.separator + "informacoes_cliente.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Cliente> clientes = informacoesCliente.stream()
                .filter(line -> {
                    var nome = extractNome(line);
                    return clienteRepository.existsByNome(nome);
                })
                .map(line -> {
                    var nome = extractNome(line);
                    var dataNascimento = extractDataNascimento(line);
                    var sexo = extractSexo(line);
                    return new Cliente(nome, dataNascimento, sexo);
                }).toList();

    }

    private Sexo extractSexo(String line) {
        Sexo sexo = Sexo.INDEFINIDO;
        char sexoChar = line.charAt(61);
        if (sexoChar == 'M') {
            sexo = Sexo.MASCULINO;
        }
        if(sexoChar == 'F') {
            sexo = Sexo.FEMININO;
        }
        return sexo;
    }

    private LocalDate extractDataNascimento(String line) {
        var dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(line.substring(50, 60), dateFormat);
    }

    private String extractNome(String line) {
        return line.substring(0, 50).trim();
    }
}
