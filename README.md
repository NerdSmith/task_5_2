# task_5_2
29. (*) «Раскрасить» двоичное дерево таким образом, что самый верхний узел был желтым, самый нижний – красным, а все промежуточные узлы – переходные от желтого к красному, в зависимости от глубины (уровня) узла (переход равномерный, т.е. второй уровень – почти желтый, середина – оранжевый, узлы на глубине – почти красные (при достаточной высоте дерева). Подсказка: необходимо модифицировать какое-то дерево в проекте TreeSamples так, чтобы его узлы содержали и возвращали цвет. Собственно алгоритм состоит из 2-х шагов: вначале найти высоту дерева, далее повторно обойти дерево, устанавливая для каждого узла цвет в соответствии с уровнем узла (пропорционально от желтого к красному).
