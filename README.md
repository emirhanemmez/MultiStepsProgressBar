# MultiStepsProgressBar

A customizable progressbar component can be used in onboarding screens for Jetpack Compose.

![MultiStepsProgressBar Preview](https://github.com/emirhanemmez/MultiStepsProgressBar/blob/main/screenshot/multistepsprogressbarpreview.png)

## Usage

Define your **stepList** as **SnapShotStateList**  in your ViewModel. For example:

```
class MainViewModel : ViewModel() {

    private val _stepList = mutableStateListOf<StepData>().apply {
        addAll(
            listOf(
                StepData(
                    stepId = Id.FirstStep,
                    stepName = "Step1",
                    progress = ProgressProperties.PROGRESS_FULL
                ),
                StepData(
                    stepId = Id.SecondStep,
                    stepName = "Step2",
                    progress = ProgressProperties.PROGRESS_NONE,
                ),
                StepData(
                    stepId = Id.ThirdStep,
                    stepName = "Step3",
                    progress = ProgressProperties.PROGRESS_HALF
                )
            )
        )
    }
    val stepList: List<StepData> = _stepList

    fun updateProgressesWithRandomValues() {
        _stepList.updateStepProgress(Id.FirstStep, Random.nextFloat())
        _stepList.updateStepProgress(Id.SecondStep, Random.nextFloat())
        _stepList.updateStepProgress(Id.ThirdStep, Random.nextFloat())
    }

    sealed class Id(id: Int) : StepId(id) {
        data object FirstStep : Id(0)
        data object SecondStep : Id(1)
        data object ThirdStep : Id(2)
    }
}
```

Observe **stepList** in your composable function:

```
class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(56.dp))

                        MultipleStepsProgressBar(
                            stepDataList = mainViewModel.stepList
                        )

                        Spacer(modifier = Modifier.height(56.dp))

                        Button(onClick = {
                            mainViewModel.updateProgressesWithRandomValues()
                        }) {
                            Text(text = "Click for random progresses")
                        }
                    }
                }
            }
        }
    }
}
```

And update progress with this extension function:

```
fun SnapshotStateList<StepData>.updateStepProgress(stepId: StepId, progress: Float) {
    val index = stepId.index
    val step = this[index]
    this[index] = step.copy(progress = progress)
}
```

For UI customization please check [StepProperties.kt](https://github.com/emirhanemmez/MultiStepsProgressBar/blob/main/multistepsprogressbar/src/main/java/com/emirhanemmez/multistepsprogressbar/model/StepProperties.kt)

