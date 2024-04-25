package frc.robot; 

import com.revrobotics.CANSparkBase.IdleMode;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile; 
import edu.wpi.first.math.util.Units; 

/**
 * A classe Constants oferece um local conveniente para as equipes segurem em todo o robô
 * numérico ou booleano
 * constantes.Esta classe não deve ser usada para nenhum outro propósito.Todas as constantes
 * deve ser declarado
 * globally (i.e. public static). Não coloque nada funcional nesta classe.
 *
 * É recomendável importar estaticamente esta classe (ou uma de suas classes internas)
 * onde quer que são necessários constantes, para reduzir a verbosidade.
 */
public final class Constants { 

  public static final class PigeonConstants {//é uma classe (PigeonConstants) 
    //estática pública final, onde está a programação do Pigeon (dispositivo 
    //usado para medir a orientação e movimento).
    public static final int Pigeon2ID = 15;//é uma constante de número inteiro 
    //(int) estática pública final, que define a constante Pigeon2ID com o valor 15.
  }

  public static final class DriveConstants {
    //é uma classe (DriveConstants) estática pública final, onde está a 
    //programação de acionamento do robô (taxas de conversão, limites, 
    //ganhos de controle e calibração).

    // Parâmetros de direção - observe que essas não são as velocidades máximas capazes de
    // o robô, mas as velocidades máximas permitidas
    public static double kMaxSpeedMetersPerSecond = 3.5; //3.5; // 2.4;  // MAC - Velocidade era 4.8
        //é uma constante de número real estática pública, no qual o nome da 
    //variável (kMaxSpeedMetersPerSecond), faz referência a velocidade 
    //máxima em metros por segundos ("k" indica constantes), e nesta 
    //situação, a velocidade máxima de metros por segundos é de 2.4 
    //(valor de inicialização aramazenado). 
    public static final double kMaxAngularSpeed = 2 * Math.PI; // Radianos por segundo (Não observei diferença)
    //é uma constante de número real estática pública final, no qual o 
    //nome da variável (kMaxAngularSpeed), representa a velocidade angular 
    //máxima, no qual está equivalea 2 vezes pi (3,14...), e, o resultado 
    //é uma rotação completa em radianos (radianos nessa situação é usado 
    //para medir ângulos de movimentos circulares).

    public static final double kDirectionSlewRate = 1.2; //1.2 // radianos por segundo
    //////é uma constante de número real estática pública final, no qual 
    //o nome da variável (kDirectionSlewRate), tem relação com ajuste para 
    //direção do movimento, e 1.2 é o valor atribuído a constante (a taxa 
    //de ajuste de direção é 1.2).
    public static final double kMagnitudeSlewRate = 1.8; // porcentagem por segundo (1 = 100%)
    //////é uma constante de número real estática pública final, no qual o 
    //nome da variável (kMagnitudeSlewRate), tem relação com a 
    //magnitude/velocidade do movimento, e 1.8 é o valor atribuído a constante 
    //(a taxa de ajuste da magnitude/velocidade do movimento é 1.8).
    public static final double kRotationalSlewRate = 2.0; //2.0; // porcentagem por segundo (1 = 100%)
    //////é uma constante de número real estática pública final, no qual o nome 
    //da variável (kRotationalSlewRate), tem relação com ajuste para a rotação 
    //do movimento, e 2.0 é o valor atribuído a constante (a taxa de ajuste 
    //para a rotação é de 2.0).

    // False = Frente do robo fixa - True = Frente relativa ao campo (ideal)
    public static boolean KFieldRelative = true;

    // True suaviza a direção - False deixa mais seco 
    public static boolean kRateLimit = true; 

    /**** MEDIDAS DO CHASSI (POLEGADAS) ****/

    // Medir da roda esquerda a roda direita
    public static final double kTrackWidth = Units.inchesToMeters(23.5); //26.5
    //é uma constante de número real estática pública final, no qual o nome da 
    //variável (kTrackWidth), tem relação com a largura do robô, e Units.inchesToMeters(26.5) 
    //é o valor atribuído a constante, mostra que a largura da frente do robô é 26.5 
    //polegadas convertidas em metros (Units.inchesToMeters faz esta conversão).

    // Medir da roda da frente a roda traseira
    public static final double kWheelBase = Units.inchesToMeters(23.5);
    //é uma constante de número real estática pública final, no qual o nome da 
    //variável (kWheelBase), tem relação com a distância dos eixos do robô, e 
    //Units.inchesToMeters(26.5) é o valor atribuído a constante, mostra que a 
    //distância dos eixos do robô é 26.5 polegadas convertidas em metros 
    //(Units.inchesToMeters faz esta conversão).


    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
    //é uma constante de número real estática pública final, declara a constante 
    //kDriveKinematics do tipo SwerveDriveKinematics, que está relacionada à 
    //cinemática do sistema de acionamento Swerve do robô, que está criando 
    //(new) uma nova instância (SwerveDriveKinematics).
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        //Frente Esquerda: cria (new) uma instância biodimensional (Translation2d), e realiza 
        //duas contas, sendo a primeira: a largura da translação na direção 
        //do eixo dos x dividida por 2 e, a segunda: a largura da translação 
        //na direção do eixo dos y dividida por 2. Cria a primeira posição 
        //de roda do swerve do chassi.
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        //Frente Direita: cria (new) uma instância biodimensional (Translation2d), e realiza 
        //duas contas, sendo a primeira: a largura dividida por 2 e, a segunda: 
        //a -largura dividida por 2. Cria a segunda posição de roda do swerve 
        //(indica que a roda está localizada na parte inferior da largura do chassi).
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        //Traseira Esquerda: cria (new) uma instância biodimensional (Translation2d), e realiza 
        //duas contas, sendo a primeira: a -largura dividida por 2 e, a segunda: 
        //a largura dividida por 2. Cria a segunda posição de roda do swerve 
        //(indica que a roda está localizada na parte oposta ao comprimento do chassi).
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));
        //Traseira Direita: cria (new) uma instância biodimensional (Translation2d), e realiza 
        //duas contas, sendo a primeira: a -largura dividida por 2 e, a segunda: 
        //a -largura dividida por 2. Cria a segunda posição de roda do swerve 
        //(indica que a roda está na parte oposta tanto em largura quanto em comprimento).

    // Compensações angulares dos módulos em relação ao chassi em radianos
    public static final double kFrontLeftChassisAngularOffset = Math.toRadians(180); //Math.PI;
    //////é uma constante de número real estática pública final, no qual o nome 
    //da variável (kFrontLeftChassisAngularOffset), que representa o deslocamento 
    //angular da roda dianteira esquerda, e o valor atribuído a mesma é de PI (180°).
    public static final double kFrontRightChassisAngularOffset = Math.toRadians(0); //0;
    //////é uma constante de número real estática pública final, no qual o nome 
    //da variável (kFrontRightChassisAngularOffset), que representa o deslocamento 
    //angular da roda dianteira direita, e o valor atribuído a mesma é de 0, 
    //orientação padrão (0°).
    public static final double kBackLeftChassisAngularOffset = Math.toRadians(180); //Math.PI;
    //////é uma constante de número real estática pública final, no qual o nome 
    //da variável (kBackLeftChassisAngularOffset), que representa o deslocamento 
    //angular da roda traseira esquerda, e o valor atribuído a mesma é de PI (180°).
    
    public static final double kBackRightChassisAngularOffset = Math.toRadians(0); //0;
    //////é uma constante de número real estática pública final, no qual o nome 
    //da variável (kBackRightChassisAngularOffset ), que representa o deslocamento 
    //angular da roda traseira direita, e o valor atribuído a mesma é de PI/2 (90°).

    /**** SPARKS IDs ****/

    // Sparks referente a movimentação da Roda (Motores maiores)
    public static final int kFrontLeftDrivingCanId = 8;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kFrontLeftDrivingCanId), representa a constante relacionada ao 
    //identificador CanId de acionamento da roda dianteira esquerda (motor grande), que é a 8.
    public static final int kRearLeftDrivingCanId = 6;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kRearLeftDrivingCanId), representa a constante relacionada ao 
    //identificador CanId de acionamento da roda traseira esquerda (motor grande), que é a 6.
    public static final int kFrontRightDrivingCanId = 2;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kFrontRightDrivingCanId), representa a constante relacionada ao 
    //identificador CanId de acionamento da roda dianteira direita (motor grande), que é a 2.
    public static final int kRearRightDrivingCanId = 4;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kRearRightDrivingCanId), representa a constante relacionada ao 
    //identificador CanId de acionamento da roda traseira direita (motor grande), que é a 4.

    // Sparks referente a angulação da Roda (Motores menores)
    public static final int kFrontLeftTurningCanId = 7;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kFrontLeftTurningCanId), representa a constante relacionada ao 
    //identificador CanId de direção da roda dianteira esquerda (motor pequeno), que é a 7.
    public static final int kRearLeftTurningCanId = 5;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kRearLeftTurningCanId), representa a constante relacionada ao 
    //identificador CanId de direção da roda traseira esquerda (motor pequeno), que é a 5.
    public static final int kFrontRightTurningCanId = 1;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kFrontRightTurningCanId), representa a constante relacionada ao 
    //identificador CanId de direção da roda dianteira direita (motor pequeno), que é a 1.
    public static final int kRearRightTurningCanId = 3;//
    //é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kFrontLeftDrivingCanId), representa a constante relacionada ao 
    //identificador CanId de direção da roda traseira direita (motor pequeno), que é a 3.


    public static final boolean kGyroReversed = false;
    //é uma constante de número booleanos (verdadeiro ou falso (boolean)) estática 
    //pública final, no qual o nome da variável (kGyroReversed), representa à reverção 
    //(ou não) a um giroscópio associado, que neste caso, é falso, naõ associado.
  }

  public static final class ArmConstants {

    // Spark do motor do braço (ARM)
    public static final int armCANIdLeft = 35;
    public static final int armCANIdRight = 36;
    public static final int armReduction = 100;  //Valor da redução de cada motor
    public static final double armFactorConverion = 2 * Math.PI;
    public static final int toothBig = 64;
    public static final int toothSmall = 40;
    public static final int armMotorCurrentLimit = 30;
    public static final int sensorDownID = 0;
    public static final int angleAngularInit = 90; // Quando o braço iniciar em pé, defina aqui o angulo de inicio do mesmo
    
    // Alinhamento automatico do motor no AMP 
    public static final double sensorDistance = 54;  //Distância em CM do sensor esquerdo para direito
    public static final int counterCheckSensor = 10;  //Quantidade de leituras que fará, para calcular uma média e ser mais assertivo
    
    // O autonomo ficará tentando alinhar a distancia do robo entre o range abaixo
    public static final int rangeMinDistance = 38;
    public static final int rangeMaxDistance = 46;

    // Esses são os limites máximos que liberará o automático funcionar. Acima disso não funcionará
    public static final int rangeAngle = 30;
    public static final int rangeDistance = 100;

  }
  /*
  Essas constantes são usadas para referenciar IDs de motores ou outros valores específicos 
  relacionados ao controle de inclinação do robô. Ao utilizar uma classe de constantes como 
  essa, é possível ajustar esses valores facilmente sem modificar diretamente o código principal, 
  tornando-o mais modular e fácil de manter.
  */

  public static final class ElevatorConstants {
    public static final int elevatorCANId = 42;
  }

  public static final class IntakeConstants {
    public static final int intakeCANidDOWN = 30;  //30
    public static final int intakeCANidUP = 31;
    public static final int digitalUpId = 0; 
    public static final int digitalDownId = 1; 
    public static final double downVelocity = 1; // Velocidade de giro do motor - 0.0 a 1.0
    public static final double upVelocity = 10; // Velocidade de giro do motor - 0.0 a 1.0
    public static final double currentMaxBattery = 12.6;
  }

  public static final class ModuleConstants {
    //é uma classe (ModuleConstants) estática pública final, que contém módulos/métodos 
    //relacionados ao código do robô.

    // The MAXSwerve module can be configured with one of three pinion gears: 12T, 13T, or 14T.
    // This changes the drive speed of the module (a pinion gear with more teeth will result in a
    // robot that drives faster).
    // O módulo MAXSwerve pode ser configurado com uma das três engrenagens de pinhão: 12T, 13T ou 14T.
    // Isso altera a velocidade de acionamento do módulo (uma engrenagem de pinhão com mais dentes resultará em
    // robô que anda mais rápido).

    // MAC - Engrenagem Torque - Maior ou menor velocidade para o Robô
    public static final int kDrivingMotorPinionTeeth = 13; // MAC - Era 14, alterei e aparentou melhora de resposta, mas testar para voltar valor
    //////é uma constante de número inteiro (int) estática pública final, no qual o nome 
    //da variável (kDrivingMotorPinionTeeth), está relacionada ao número de dentes do pinhão 
    //(engrenagem pequena) do motor de acionamento, que neste caso, foi denominada 13 dentes de pinhão.

    // Invert the turning encoder, since the output shaft rotates in the opposite direction of
    // the steering motor in the MAXSwerve Module.
    // Inverte o codificador giratório, pois o eixo de saída gira no sentido oposto ao
    // o motor de direção no Módulo MAXSwerve.

    // MAC - Cuidado ao alterar a propriedade abaixo
    public static final boolean kTurningEncoderInverted = true;
    //é uma constante de número booleanos (verdadeiro ou falso (boolean)) estática pública 
    //final, no qual o nome da variável (kTurningEncoderInverted), que representa à versão 
    //(ou não) de um encoder (dispositivo utilizado para medir a posição, velocidade e direção 
    //de um objeto em movimento) associado ao sistema de direção (giro ou torneamento) do robô, 
    //que neste caso, é true, é associada a versão.

    // Cálculos necessários para acionar fatores de conversão do motor e alimentação para a frente
    public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
    /*
    Calcula a velocidade livre do motor de acionamento (kDrivingMotorFreeSpeedRps) em rotações por segundo,
    usando a constante kFreeSpeedRpm da classe NeoMotorConstants e dividindo por 60 para converter para rotações por segundo.
    */
    public static final double kWheelDiameterMeters = 0.0762;
    /*
    Define o diâmetro da roda em metros (kWheelDiameterMeters) na classe ModuleConstants,
    representando as dimensões físicas das rodas.
    */
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
    /*
    Calcula a circunferência da roda em metros (kWheelCircumferenceMeters),
    multiplicando o diâmetro da roda (kWheelDiameterMeters) pelo valor de π.
    Isso é feito na classe ModuleConstants.
    */

    // 45 dentes na engrenagem chanfrada da roda,
    // 22 dentes na engrenagem de esporão da primeira etapa, 15 dentes no pinhão chanfrado
    public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
    /*
    Calcula a redução do motor de acionamento (kDrivingMotorReduction) na classe ModuleConstants. 
    O cálculo envolve a multiplicação de 45.0 por 22 
    e a divisão pelo número de dentes do pinhão do motor de acionamento (kDrivingMotorPinionTeeth) multiplicado por 15.
    */ 

    public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
        / kDrivingMotorReduction;
    /* Calcula a velocidade livre das rodas de acionamento (kDriveWheelFreeSpeedRps) na classe ModuleConstants.
    A fórmula envolve a multiplicação da velocidade livre do motor de acionamento (kDrivingMotorFreeSpeedRps),
    pela circunferência da roda em metros (kWheelCircumferenceMeters),
    e a divisão pela redução do motor de acionamento (kDrivingMotorReduction).
    */

    public static final double kDrivingEncoderPositionFactor = (kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction; // metros
    /* 
    Calcula o fator de conversão para a posição do encoder de acionamento (`kDrivingEncoderPositionFactor`) na classe `ModuleConstants`.
    O cálculo envolve a multiplicação do diâmetro da roda em metros (`kWheelDiameterMeters`),
    pelo valor de π e a divisão pela redução do motor de acionamento (`kDrivingMotorReduction`).
    Esse fator é utilizado para converter as unidades de posição do encoder para metros no contexto do sistema de acionamento do robô.
    */

    public static final double kDrivingEncoderVelocityFactor = ((kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction) / 60.0; // metros por segundo
    /*
    Calcula o fator de conversão para a velocidade do encoder de acionamento (kDrivingEncoderVelocityFactor) na classe ModuleConstants.
    O cálculo envolve a multiplicação do diâmetro da roda em metros (kWheelDiameterMeters) pelo valor de π, 
    a divisão pela redução do motor de acionamento (kDrivingMotorReduction), 
    e então a divisão por 60.0 para converter a velocidade para metros por segundo.
    */   

    public static final double kTurningEncoderPositionFactor = (2 * Math.PI); // radianos
    /*
    Define o fator de conversão para a posição do encoder de direção (kTurningEncoderPositionFactor) na classe ModuleConstants.
    O valor é simplesmente 2 vezes o valor de π, representando uma rotação completa em radianos.
    */
    public static final double kTurningEncoderVelocityFactor = (2 * Math.PI) / 60.0; // radianos por segundo
    /*
    Define o fator de conversão para a velocidade do encoder de direção (kTurningEncoderVelocityFactor) na classe ModuleConstants.
    O valor é calculado como 2 vezes o valor de π dividido por 60,
    representa a conversão de rotações por minuto para radianos por segundo.
    */

    public static final double kTurningEncoderPositionPIDMinInput = 0; // radianos
    /*
    Define o valor mínimo de entrada para o controlador proporcional,
    integral e derivativo (PID) da posição do encoder de direção (kTurningEncoderPositionPIDMinInput).
    Nesse caso, é zero, indicando que o controlador PID de posição da direção,
    aceita valores a partir de zero radianos como entrada mínima para o cálculo do controle.
    */
    public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radianos
    /*
    Define o valor máximo de entrada para o controlador proporcional,
    integral e derivativo (PID) da posição do encoder de direção (kTurningEncoderPositionPIDMaxInput).
    O valor máximo é definido como kTurningEncoderPositionFactor, que representa 2 * π,
    indicando que o controlador PID de posição da direção aceita valores até 2π radianos como entrada máxima para o cálculo do controle.
    */

    public static final double kDrivingP = 0.04;
    /*
    Define o ganho proporcional para o controlador proporcional, 
    integral e derivativo da posição de acionamento (kDrivingP). 
    O valor 0.04 representa o ganho proporcional específico para esse controlador, 
    ajustando a resposta do sistema para atingir a posição desejada do motor de acionamento.
    */
    public static final double kDrivingI = 0;
    /*
    Define o ganho integral para o controlador proporcional, 
    integral e derivativo da posição de acionamento (kDrivingI). 
    O valor 0 indica que o componente integral não está sendo utilizado neste caso específico, 
    o que significa que não há correção contínua para o erro acumulado ao longo do tempo.
    */
    public static final double kDrivingD = 0;
    /*
    Define o ganho derivativo para o controlador proporcional,
    integral e derivativo da posição de acionamento (kDrivingD).
    O valor 0 indica que o componente derivativo não está sendo utilizado neste caso específico,
    o que significa que não há correção com base na taxa de variação do erro.
    */
    public static final double kDrivingFF = 1 / kDriveWheelFreeSpeedRps;
    /*
   Define o termo de "feedforward" para o controlador proporcional, 
   integral e derivativo da velocidade de acionamento (''kDrivingFF''). 
   O valor é calculado como o inverso da velocidade livre do motor de acionamento dividido pela taxa de variação da posição. 
   O termo de feedforward é uma componente do controle PID que antecipa e compensa a inércia do sistema, 
   contribuindo para uma resposta mais rápida e precisa.
   */
    public static final double kDrivingMinOutput = -1;
    /*
    Define o valor mínimo de saída (kDrivingMinOutput) para o controlador proporcional, 
    integral e derivativo da velocidade de acionamento. 
    O valor é configurado como -1, indicando que a saída mínima permitida para o controlador é -1. 
    Isso geralmente está associado à direção ou à velocidade mínima permitida para o motor de acionamento.
    */
    public static final double kDrivingMaxOutput = 1;
    /*
    Define o valor máximo de saída para o controle de velocidade de acionamento (kDrivingMaxOutput).
    Em sistemas de controle PID, esse valor é usado para limitar a saída do controlador,
    garantindo que o sistema não ultrapasse velocidades ou posições desejadas.
    Neste caso, o valor máximo de saída para o controle de velocidade de acionamento é definido como 1,
    o que significa que a saída do controlador não pode exceder 1. Isso é comum,
    já que as saídas de controle geralmente estão normalizadas entre -1 e 1.
    */
    public static final double kTurningP = 2; //1;
    /*
    Define o valor do coeficiente proporcional para o controle proporcional do sistema de giro (kTurningP).
    Em um controlador PID (Proporcional, Integral, Derivativo), 
    o termo proporcional ajusta a saída do controlador com base no erro atual, 
    que é a diferença entre a posição desejada e a posição real. 
    Um valor maior de kTurningP aumenta a contribuição proporcional, 
    o que pode resultar em uma resposta mais rápida do sistema à medida que tenta reduzir o erro mais rapidamente. 
    O ajuste fino desse valor depende das características específicas do sistema e do desempenho desejado.
    */
    public static final double kTurningI = 0;
    /*
    Define o valor do coeficiente integral para o controle integral do sistema de giro (kTurningI).
    Em um controlador PID (Proporcional, Integral, Derivativo),
    o termo integral ajusta a saída do controlador com base na acumulação do erro ao longo do tempo.
    No caso de kTurningI ser zero, não há contribuição integral no controle,
    o que significa que o controlador não considera a integral do erro. 
    */
    public static final double kTurningD = 1;
    /*
    Define o valor do coeficiente derivativo para o controle derivativo do sistema de giro (kTurningD).
    Em um controlador PID, o termo derivativo ajusta a saída do controlador com base na taxa de variação do erro.
    Quando kTurningD é zero, não há contribuição derivativa no controle,
    o que significa que o controlador não considera a derivada do erro.
    */
    public static final double kTurningFF = 0;
    /*
    Define o valor do termo de "feedforward" para o controle de giro (kTurningFF). 
    O termo de feedforward é usado para compensar o atrito e outras resistências no sistema,
    proporcionando uma resposta mais rápida. Quando kTurningFF é zero,
    não há contribuição de feedforward no controle,
    o que significa que o controlador não leva em consideração uma estimativa antecipada da saída necessária.
    */
    public static final double kTurningMinOutput = -1;
    /*
    Define o valor mínimo de saída (kTurningMinOutput) para o controle de giro.
    Em contextos de controle, especialmente quando se utiliza PID,
    é comum especificar limites para a saída do controlador.
    Neste caso, "kTurningMinOutput" é configurado como -1, indicando que a saída mínima permitida para o controle de giro é -1.
    Este valor é muitas vezes utilizado para limitar a velocidade ou a potência de um atuador no sistema de controle,
    garantindo que ele não ultrapasse determinados limites.
    */
    public static final double kTurningMaxOutput = 1;
    /*
    Define o valor máximo de saída (`kTurningMaxOutput`) para o controle de giro.
    Em contextos de controle, especialmente quando se utiliza PID,
    é comum especificar limites para a saída do controlador. Neste caso, "kTurningMaxOutput" é configurado como 1,
    indicando que a saída máxima permitida para o controle de giro é 1.
    Este valor é frequentemente utilizado para limitar a velocidade ou a potência de um atuador no sistema de controle,
    garantindo que ele não ultrapasse determinados limites.
    */

    public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;  
    
    /*
   Define o modo de inatividade ("kDrivingMotorIdleMode") para o motor de condução.
   O valor "IdleMode.kBrake" indica que o freio deve ser aplicado quando o motor não está em movimento.
   Em sistemas de controle de robôs,
   configurar o modo de inatividade é útil para controlar o comportamento dos motores quando não estão sendo acionados ativamente.
   O modo "freio" ajuda a manter o robô estável quando não está se movendo,
   enquanto o modo "coast" permite que o robô deslize mais livremente quando não está sob controle ativo.
   */
    public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;
    /*
    Define o modo de inatividade ("kTurningMotorIdleMode") para o motor de direção.
    O valor "IdleMode.kBrake" indica que o freio deve ser aplicado quando o motor não está em movimento.
    Similar ao modo de inatividade do motor de condução,
    configurar o modo de inatividade para o motor de direção,
    ajuda a controlar o comportamento do motor quando não está sendo acionado ativamente,
    contribuindo para a estabilidade e controle geral do robô.
   */

    public static final int kDrivingMotorCurrentLimit = 50; // amps // amplificadores // Não alterar
    /*
    Define o limite de corrente (`kDrivingMotorCurrentLimit`) para o motor de condução.
    O valor "50" representa o limite de corrente em amperes, ou seja,
    o motor de condução não deve exceder esse limite de corrente durante seu funcionamento normal.
    Estabelecer limites de corrente é uma prática comum para evitar danos,
    aos motores e garantir um funcionamento seguro do sistema elétrico do robô.
    */
    public static final int kTurningMotorCurrentLimit = 20; // amps // amplificadores // Não alterar
    /*
    Define o limite de corrente ("kTurningMotorCurrentLimit") para o motor de direção.
    O valor "20" representa o limite de corrente em amperes, ou seja,
    o motor de direção não deve exceder esse limite de corrente durante seu funcionamento normal.
    Estabelecer limites de corrente é uma prática comum,
    para evitar danos aos motores e garantir um funcionamento seguro do sistema elétrico do robô.
    O motor de direção geralmente consome menos corrente do que o motor de condução, 
    por isso possui um limite de corrente menor.
    */
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    /*
    Define a porta do controlador do motorista (kDriverControllerPort) na classe OIConstants,
    indicando a porta à qual o joystick do motorista está conectado.
   */
    public static final int kControlControllerPort = 1;
    //É uma classe pública estática final, de número inteiro, chamada kControlControllerPort,
    //que tem como valor atribuído o 1.
    //Define a porta do controlador na classe OIConstants, indicando qual porta (joystick)
    //está conectada ao robô

    // Limite do controle Drive
    public static final double kDriveDeadband = 0.2;
    
    // Limite  do controle Turning
    public static final double kTurningDeadband = 0.2;
    /*
    Define a sensibilidade do joystick (kDriveDeadband) na classe OIConstants, 
    indica que valores de 0.4 são considerados mortos, ou seja, não geram resposta no controle.
    */
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 2.4; // MAC - Velocidade do autonomo: 3
    public static final double kMaxAccelerationMetersPerSecondSquared = 1.5;   // MAC - Velocidade anterior 3
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    /* 
    Define a velocidade angular máxima (kMaxAngularSpeedRadiansPerSecond) como π na classe AutoConstants,
    limitando a velocidade angular máxima durante movimentos.
    */
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
    /*
    Define a aceleração angular máxima (kMaxAngularSpeedRadiansPerSecondSquared) como π na classe AutoConstants,
    limitando a taxa de mudança da velocidade angular durante movimentos automatizados do robô.
    */ 

    public static final double kPXController = 1; // Define o ganho proporcional (kPXController) na classe AutoConstants, influenciando o controle de posição X durante movimentos.
    public static final double kPYController = 1; // Define o ganho proporcional (kPYController) na classe AutoConstants, influenciando o controle de posição Y durante movimentos.
    public static final double kPThetaController = 1; // Define o ganho proporcional (`kPThetaController`) na classe `AutoConstants`, influenciando o controle angular do robô durante movimentos.

    // Restrição para o controlador de ângulo de robô perfilado de movimento
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
        kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }
  /*
  Estabelece restrições para o movimento angular no controle autônomo,
  armazenando limites de velocidade e aceleração angular na constante "kThetaControllerConstraints" em "AutoConstants".
  */

  public static final class NeoMotorConstants {
    public static final double kFreeSpeedRpm = 5676;
    /*
    Define a constante kFreeSpeedRpm como 5676. Essa constante representa a velocidade livre do motor em rotações por minuto (RPM).
    No contexto do código fornecido, essa constante é utilizada em cálculos relacionados ao motor,
    como a conversão de velocidades para unidades apropriadas.
    */
  }
}
