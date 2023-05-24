package periodic_table;

import java.util.HashMap;
import java.util.Map;

public abstract class Elements {
  public enum Category {
    ACTINIDE, ALKALI, ALKALINE_EARTH, LANTHANIDE, METALLOID, NOBLE_GAS, POST_TRANSITION, REACTIVE_NONMETAL, TRANSITION, UNKNOWN;
  }
  
  public enum Phase {
    SOLID, LIQUID, GAS, UNKNOWN;
  }
  
  public enum Element {
    H(1, "Hydrogen", 1.008D, 13.99D, 20.271D, 0.08988D, Elements.Phase.GAS, 1, 1, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Hydrogen_discharge_tube.jpg/440px-Hydrogen_discharge_tube.jpg"),
    He(2, "Helium", 4.003D, 0.95D, 4.222D, 0.1786D, Elements.Phase.GAS, 18, 1, Elements.Category.NOBLE_GAS, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Helium_discharge_tube.jpg/440px-Helium_discharge_tube.jpg"),
    Li(3, "Lithium", 6.941D, 453.65D, 1603.0D, 0.534D, Elements.Phase.SOLID, 1, 2, Elements.Category.ALKALI, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Lithium_paraffin.jpg/440px-Lithium_paraffin.jpg"),
    Be(4, "Beryllium", 9.012D, 1560.0D, 2742.0D, 1.85D, Elements.Phase.SOLID, 2, 2, Elements.Category.ALKALINE_EARTH, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Be-140g.jpg/280px-Be-140g.jpg"),
    B(5, "Boron", 10.811D, 2349.0D, 4200.0D, 2.08D, Elements.Phase.SOLID, 13, 2, Elements.Category.METALLOID, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Boron_R105.jpg/440px-Boron_R105.jpg"),
    C(6, "Carbon", 12.011D, 0.0D, 0.0D, 2.267D, Elements.Phase.SOLID, 14, 2, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Graphite-and-diamond-with-scale.jpg/440px-Graphite-and-diamond-with-scale.jpg"),
    N(7, "Nitrogen", 14.007D, 63.15D, 77.355D, 1.2506D, Elements.Phase.GAS, 15, 2, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Liquidnitrogen.jpg/440px-Liquidnitrogen.jpg"),
    O(8, "Oxygen", 15.999D, 54.36D, 90.188D, 1.429D, Elements.Phase.GAS, 16, 2, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Liquid_oxygen_in_a_beaker_4.jpg/300px-Liquid_oxygen_in_a_beaker_4.jpg"),
    F(9, "Fluorine", 18.998D, 53.48D, 85.03D, 1.696D, Elements.Phase.GAS, 17, 2, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/9/91/Liquid_fluorine_tighter_crop.jpg"),
    Ne(10, "Neon", 20.18D, 24.56D, 27.104D, 0.9002D, Elements.Phase.GAS, 18, 2, Elements.Category.NOBLE_GAS, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Neon_discharge_tube.jpg/440px-Neon_discharge_tube.jpg"),
    Na(11, "Sodium", 22.99D, 370.944D, 1156.09D, 0.968D, Elements.Phase.SOLID, 1, 3, Elements.Category.ALKALI, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Na_%28Sodium%29.jpg/440px-Na_%28Sodium%29.jpg"),
    Mg(12, "Magnesium", 24.305D, 923.0D, 1363.0D, 1.738D, Elements.Phase.SOLID, 2, 3, Elements.Category.ALKALINE_EARTH, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/CSIRO_ScienceImage_2893_Crystalised_magnesium.jpg/440px-CSIRO_ScienceImage_2893_Crystalised_magnesium.jpg"),
    Al(13, "Aluminium", 26.982D, 933.47D, 2743.0D, 2.7D, Elements.Phase.SOLID, 13, 3, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Aluminium-4.jpg/440px-Aluminium-4.jpg"),
    Si(14, "Silicon", 28.086D, 1687.0D, 3538.0D, 2.329D, Elements.Phase.SOLID, 14, 3, Elements.Category.METALLOID, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/SiliconCroda.jpg/440px-SiliconCroda.jpg"),
    P(15, "Phosphorus", 30.974D, 317.3D, 553.7D, 1.823D, Elements.Phase.SOLID, 15, 3, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/PhosphComby.jpg/440px-PhosphComby.jpg"),
    S(16, "Sulfur", 32.065D, 388.36D, 717.8D, 1.96D, Elements.Phase.SOLID, 16, 3, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Sulfur-sample.jpg/440px-Sulfur-sample.jpg"),
    Cl(17, "Chlorine", 35.453D, 171.6D, 239.11D, 3.2D, Elements.Phase.GAS, 17, 3, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Chlorine_ampoule.jpg/440px-Chlorine_ampoule.jpg"),
    Ar(18, "Argon", 39.948D, 83.81D, 87.302D, 1.784D, Elements.Phase.GAS, 18, 3, Elements.Category.NOBLE_GAS, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/Argon_discharge_tube.jpg/440px-Argon_discharge_tube.jpg"),
    K(19, "Potassium", 39.098D, 336.7D, 1032.0D, 0.862D, Elements.Phase.SOLID, 1, 4, Elements.Category.ALKALI, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Potassium-2.jpg/440px-Potassium-2.jpg"),
    Ca(20, "Calcium", 40.078D, 1115.0D, 1757.0D, 1.55D, Elements.Phase.SOLID, 2, 4, Elements.Category.ALKALINE_EARTH, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Calcium_unter_Argon_Schutzgasatmosph"),
    Sc(21, "Scandium", 44.956D, 1814.0D, 3109.0D, 2.985D, Elements.Phase.SOLID, 3, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Scandium_sublimed_dendritic_and_1cm3_cube.jpg/440px-Scandium_sublimed_dendritic_and_1cm3_cube.jpg"),
    Ti(22, "Titanium", 47.867D, 1941.0D, 3560.0D, 4.506D, Elements.Phase.SOLID, 4, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Titan-crystal_bar.JPG/440px-Titan-crystal_bar.JPG"),
    V(23, "Vanadium", 50.942D, 2183.0D, 3680.0D, 6.0D, Elements.Phase.SOLID, 5, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Vanadium_etched.jpg/440px-Vanadium_etched.jpg"),
    Cr(24, "Chromium", 51.996D, 2180.0D, 2944.0D, 7.19D, Elements.Phase.SOLID, 6, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Chromium_crystals_and_1cm3_cube.jpg/440px-Chromium_crystals_and_1cm3_cube.jpg"),
    Mn(25, "Manganese", 54.938D, 1519.0D, 2334.0D, 7.21D, Elements.Phase.SOLID, 7, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/8/86/Mangan_1-crop.jpg"),
    Fe(26, "Iron", 55.845D, 1811.0D, 3134.0D, 7.874D, Elements.Phase.SOLID, 8, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Iron_electrolytic_and_1cm3_cube.jpg/440px-Iron_electrolytic_and_1cm3_cube.jpg"),
    Co(27, "Cobalt", 58.933D, 1768.0D, 3200.0D, 8.9D, Elements.Phase.SOLID, 9, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Kobalt_electrolytic_and_1cm3_cube.jpg/440px-Kobalt_electrolytic_and_1cm3_cube.jpg"),
    Ni(28, "Nickel", 58.693D, 1728.0D, 3003.0D, 8.908D, Elements.Phase.SOLID, 10, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Nickel_chunk.jpg/380px-Nickel_chunk.jpg"),
    Cu(29, "Copper", 63.546D, 1357.77D, 2835.0D, 8.96D, Elements.Phase.SOLID, 11, 4, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/440px-NatCopper.jpg"),
    Zn(30, "Zinc", 65.39D, 692.68D, 1180.0D, 7.14D, Elements.Phase.SOLID, 12, 4, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Zinc_fragment_sublimed_and_1cm3_cube.jpg/440px-Zinc_fragment_sublimed_and_1cm3_cube.jpg"),
    Ga(31, "Gallium", 69.723D, 302.915D, 2673.0D, 5.91D, Elements.Phase.SOLID, 13, 4, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Gallium_crystals.jpg/440px-Gallium_crystals.jpg"),
    Ge(32, "Germanium", 72.64D, 1211.4D, 3106.0D, 5.323D, Elements.Phase.SOLID, 14, 4, Elements.Category.METALLOID, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Polycrystalline-germanium.jpg/440px-Polycrystalline-germanium.jpg"),
    As(33, "Arsenic", 74.922D, 0.0D, 0.0D, 5.727D, Elements.Phase.SOLID, 15, 4, Elements.Category.METALLOID, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/Arsen_1a.jpg/440px-Arsen_1a.jpg"),
    Se(34, "Selenium", 78.96D, 494.0D, 958.0D, 4.81D, Elements.Phase.SOLID, 16, 4, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/SeBlackRed.jpg/440px-SeBlackRed.jpg"),
    Br(35, "Bromine", 79.904D, 265.8D, 332.0D, 3.1028D, Elements.Phase.LIQUID, 17, 4, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Bromine_25ml_%28transparent%29.png/340px-Bromine_25ml_%28transparent%29.png"),
    Kr(36, "Krypton", 83.8D, 115.78D, 119.93D, 3.749D, Elements.Phase.GAS, 18, 4, Elements.Category.NOBLE_GAS, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Krypton_discharge_tube.jpg/440px-Krypton_discharge_tube.jpg"),
    Rb(37, "Rubidium", 85.468D, 312.45D, 961.0D, 1.532D, Elements.Phase.SOLID, 1, 5, Elements.Category.ALKALI, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Rb5.JPG/440px-Rb5.JPG"),
    Sr(38, "Strontium", 87.62D, 1050.0D, 1650.0D, 2.64D, Elements.Phase.SOLID, 2, 5, Elements.Category.ALKALINE_EARTH, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Strontium_destilled_crystals.jpg/440px-Strontium_destilled_crystals.jpg"),
    Y(39, "Yttrium", 88.906D, 1799.0D, 3203.0D, 4.472D, Elements.Phase.SOLID, 3, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Yttrium_sublimed_dendritic_and_1cm3_cube.jpg/440px-Yttrium_sublimed_dendritic_and_1cm3_cube.jpg"),
    Zr(40, "Zirconium", 91.224D, 2128.0D, 4650.0D, 6.53D, Elements.Phase.SOLID, 4, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Zirconium_crystal_bar_and_1cm3_cube.jpg/440px-Zirconium_crystal_bar_and_1cm3_cube.jpg"),
    Nb(41, "Niobium", 92.906D, 2750.0D, 5017.0D, 8.57D, Elements.Phase.SOLID, 5, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Niobium_crystals_and_1cm3_cube.jpg/440px-Niobium_crystals_and_1cm3_cube.jpg"),
    Mo(42, "Molybdenum", 95.94D, 2896.0D, 4912.0D, 10.28D, Elements.Phase.SOLID, 6, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Molybdenum_crystaline_fragment_and_1cm3_cube.jpg/440px-Molybdenum_crystaline_fragment_and_1cm3_cube.jpg"),
    Tc(43, "Technetium", 98.0D, 2430.0D, 4538.0D, 11.0D, Elements.Phase.SOLID, 7, 5, Elements.Category.TRANSITION, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/en/8/89/Technetium.jpg"),
    Ru(44, "Ruthenium", 101.07D, 2607.0D, 4423.0D, 12.45D, Elements.Phase.SOLID, 8, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Ruthenium_a_half_bar.jpg/440px-Ruthenium_a_half_bar.jpg"),
    Rh(45, "Rhodium", 102.906D, 2237.0D, 3968.0D, 12.41D, Elements.Phase.SOLID, 9, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Rhodium_powder_pressed_melted.jpg/440px-Rhodium_powder_pressed_melted.jpg"),
    Pd(46, "Palladium", 106.42D, 1828.05D, 3236.0D, 12.023D, Elements.Phase.SOLID, 10, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Palladium_%2846_Pd%29.jpg/440px-Palladium_%2846_Pd%29.jpg"),
    Ag(47, "Silver", 107.868D, 1234.93D, 2435.0D, 10.49D, Elements.Phase.SOLID, 11, 5, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Silver_crystal.jpg/440px-Silver_crystal.jpg"),
    Cd(48, "Cadmium", 112.411D, 594.22D, 1040.0D, 8.65D, Elements.Phase.SOLID, 12, 5, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Cadmium-crystal_bar.jpg/440px-Cadmium-crystal_bar.jpg"),
    In(49, "Indium", 114.818D, 429.749D, 2345.0D, 7.31D, Elements.Phase.SOLID, 13, 5, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Indium.jpg/440px-Indium.jpg"),
    Sn(50, "Tin", 118.71D, 505.08D, 2875.0D, 7.265D, Elements.Phase.SOLID, 14, 5, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Sn-Alpha-Beta.jpg/440px-Sn-Alpha-Beta.jpg"),
    Sb(51, "Antimony", 121.76D, 903.78D, 1908.0D, 6.697D, Elements.Phase.SOLID, 15, 5, Elements.Category.METALLOID, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Antimony-4.jpg/440px-Antimony-4.jpg"),
    Te(52, "Tellurium", 127.6D, 722.66D, 1261.0D, 6.24D, Elements.Phase.SOLID, 16, 5, Elements.Category.METALLOID, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Tellurium2.jpg/440px-Tellurium2.jpg"),
    I(53, "Iodine", 126.905D, 386.85D, 457.4D, 4.933D, Elements.Phase.SOLID, 17, 5, Elements.Category.REACTIVE_NONMETAL, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Sample_of_iodine.jpg/440px-Sample_of_iodine.jpg"),
    Xe(54, "Xenon", 131.293D, 161.4D, 165.051D, 5.894D, Elements.Phase.GAS, 18, 5, Elements.Category.NOBLE_GAS, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Xenon_discharge_tube.jpg/440px-Xenon_discharge_tube.jpg"),
    Cs(55, "Caesium", 132.906D, 301.7D, 944.0D, 1.93D, Elements.Phase.SOLID, 1, 6, Elements.Category.ALKALI, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Cesium.jpg/440px-Cesium.jpg"),
    Ba(56, "Barium", 137.327D, 1000.0D, 2118.0D, 3.51D, Elements.Phase.SOLID, 2, 6, Elements.Category.ALKALINE_EARTH, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Barium_unter_Argon_Schutzgas_Atmosph),
    La(57, "Lanthanum", 138.906D, 1193.0D, 3737.0D, 6.162D, Elements.Phase.SOLID, 3, 6, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Lanthanum-2.jpg/440px-Lanthanum-2.jpg"),
    Ce(58, "Cerium", 140.116D, 1068.0D, 3716.0D, 6.77D, Elements.Phase.SOLID, 4, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Cerium2.jpg/440px-Cerium2.jpg"),
    Pr(59, "Praseodymium", 140.908D, 1208.0D, 3403.0D, 6.77D, Elements.Phase.SOLID, 5, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Praseodymium.jpg/440px-Praseodymium.jpg"),
    Nd(60, "Neodymium", 144.24D, 1297.0D, 3347.0D, 7.01D, Elements.Phase.SOLID, 6, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Neodymium2.jpg/440px-Neodymium2.jpg"),
    Pm(61, "Promethium", 145.0D, 1315.0D, 3237.0D, 7.26D, Elements.Phase.SOLID, 7, 8, Elements.Category.LANTHANIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/en/5/5d/Pm%2C61.jpg"),
    Sm(62, "Samarium", 150.36D, 1345.0D, 2173.0D, 7.52D, Elements.Phase.SOLID, 8, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Samarium-2.jpg/440px-Samarium-2.jpg"),
    Eu(63, "Europium", 151.964D, 1099.0D, 1802.0D, 5.264D, Elements.Phase.SOLID, 9, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Europium.jpg/440px-Europium.jpg"),
    Gd(64, "Gadolinium", 157.25D, 1585.0D, 3273.0D, 7.9D, Elements.Phase.SOLID, 10, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Gadolinium-4.jpg/440px-Gadolinium-4.jpg"),
    Tb(65, "Terbium", 158.925D, 1629.0D, 3396.0D, 8.23D, Elements.Phase.SOLID, 11, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Terbium-2.jpg/440px-Terbium-2.jpg"),
    Dy(66, "Dysprosium", 162.5D, 1680.0D, 2840.0D, 8.54D, Elements.Phase.SOLID, 12, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Dy_chips.jpg/440px-Dy_chips.jpg"),
    Ho(67, "Holmium", 164.93D, 1734.0D, 2873.0D, 8.79D, Elements.Phase.SOLID, 13, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Holmium2.jpg/440px-Holmium2.jpg"),
    Er(68, "Erbium", 167.259D, 1802.0D, 3141.0D, 9.066D, Elements.Phase.SOLID, 14, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/1/12/Erbium-crop.jpg"),
    Tm(69, "Thulium", 168.934D, 1818.0D, 2223.0D, 9.32D, Elements.Phase.SOLID, 15, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thulium_sublimed_dendritic_and_1cm3_cube.jpg/440px-Thulium_sublimed_dendritic_and_1cm3_cube.jpg"),
    Yb(70, "Ytterbium", 173.04D, 1097.0D, 1469.0D, 6.9D, Elements.Phase.SOLID, 16, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Ytterbium-3.jpg/440px-Ytterbium-3.jpg"),
    Lu(71, "Lutetium", 174.967D, 1925.0D, 3675.0D, 9.841D, Elements.Phase.SOLID, 17, 8, Elements.Category.LANTHANIDE, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Lutetium_sublimed_dendritic_and_1cm3_cube.jpg/440px-Lutetium_sublimed_dendritic_and_1cm3_cube.jpg"),
    Hf(72, "Hafnium", 178.49D, 2506.0D, 4876.0D, 13.31D, Elements.Phase.SOLID, 4, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Hf-crystal_bar.jpg/440px-Hf-crystal_bar.jpg"),
    Ta(73, "Tantalum", 180.948D, 3290.0D, 5731.0D, 16.69D, Elements.Phase.SOLID, 5, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Tantalum_single_crystal_and_1cm3_cube.jpg/440px-Tantalum_single_crystal_and_1cm3_cube.jpg"),
    W(74, "Tungsten", 183.84D, 3695.0D, 6203.0D, 19.3D, Elements.Phase.SOLID, 6, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Wolfram_evaporated_crystals_and_1cm3_cube.jpg/440px-Wolfram_evaporated_crystals_and_1cm3_cube.jpg"),
    Re(75, "Rhenium", 186.207D, 3459.0D, 5903.0D, 21.02D, Elements.Phase.SOLID, 7, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Rhenium_single_crystal_bar_and_1cm3_cube.jpg/440px-Rhenium_single_crystal_bar_and_1cm3_cube.jpg"),
    Os(76, "Osmium", 190.23D, 3306.0D, 5285.0D, 22.59D, Elements.Phase.SOLID, 8, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Osmium_crystals.jpg/440px-Osmium_crystals.jpg"),
    Ir(77, "Iridium", 192.217D, 2719.0D, 4403.0D, 22.56D, Elements.Phase.SOLID, 9, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Iridium-2.jpg/440px-Iridium-2.jpg"),
    Pt(78, "Platinum", 195.078D, 2041.4D, 4098.0D, 21.45D, Elements.Phase.SOLID, 10, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Platinum_crystals.jpg/440px-Platinum_crystals.jpg"),
    Au(79, "Gold", 196.967D, 1337.33D, 3243.0D, 19.3D, Elements.Phase.SOLID, 11, 6, Elements.Category.TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Gold-crystals.jpg/440px-Gold-crystals.jpg"),
    Hg(80, "Mercury", 200.59D, 234.321D, 629.88D, 13.534D, Elements.Phase.LIQUID, 12, 6, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Pouring_liquid_mercury_bionerd.jpg/440px-Pouring_liquid_mercury_bionerd.jpg"),
    Tl(81, "Thallium", 204.383D, 577.0D, 1746.0D, 11.85D, Elements.Phase.SOLID, 13, 6, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Thallium_pieces_in_ampoule.jpg/440px-Thallium_pieces_in_ampoule.jpg"),
    Pb(82, "Lead", 207.2D, 600.61D, 2022.0D, 11.34D, Elements.Phase.SOLID, 14, 6, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Lead_electrolytic_and_1cm3_cube.jpg/440px-Lead_electrolytic_and_1cm3_cube.jpg"),
    Bi(83, "Bismuth", 208.98D, 544.7D, 1837.0D, 9.78D, Elements.Phase.SOLID, 15, 6, Elements.Category.POST_TRANSITION, false, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Bismuth_crystals_and_1cm3_cube.jpg/440px-Bismuth_crystals_and_1cm3_cube.jpg"),
    Po(84, "Polonium", 209.0D, 527.0D, 1235.0D, 9.196D, Elements.Phase.SOLID, 16, 6, Elements.Category.POST_TRANSITION, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/en/6/66/Polonium.jpg"),
    At(85, "Astatine", 210.0D, 575.0D, 610.0D, 0.0D, Elements.Phase.SOLID, 17, 6, Elements.Category.METALLOID, true, (Elements.Category)""),
    Rn(86, "Radon", 222.0D, 202.0D, 211.5D, 9.73D, Elements.Phase.GAS, 18, 6, Elements.Category.NOBLE_GAS, true, (Elements.Category)""),
    Fr(87, "Francium", 223.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.SOLID, 1, 7, Elements.Category.ALKALI, true, (Elements.Category)""),
    Ra(88, "Radium", 226.0D, 973.0D, 2010.0D, 5.5D, Elements.Phase.SOLID, 2, 7, Elements.Category.ALKALINE_EARTH, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Radium226.jpg/440px-Radium226.jpg"),
    Ac(89, "Actinium", 227.0D, 1500.0D, 3500.0D, 10.0D, Elements.Phase.SOLID, 3, 7, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/f/f3/Actinium.jpg"),
    Th(90, "Thorium", 232.038D, 2023.0D, 5061.0D, 11.7D, Elements.Phase.SOLID, 4, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Thorium_sample_0.1g.jpg/440px-Thorium_sample_0.1g.jpg"),
    Pa(91, "Protactinium", 231.036D, 1841.0D, 4300.0D, 15.37D, Elements.Phase.SOLID, 5, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/en/0/05/Protactinium.jpg"),
    U(92, "Uranium", 238.029D, 1405.3D, 4404.0D, 19.1D, Elements.Phase.SOLID, 6, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/HEUraniumC.jpg/440px-HEUraniumC.jpg"),
    Np(93, "Neptunium", 237.0D, 912.0D, 4447.0D, 20.45D, Elements.Phase.SOLID, 7, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Np_sphere.jpg/440px-Np_sphere.jpg"),
    Pu(94, "Plutonium", 244.0D, 912.5D, 3505.0D, 19.816D, Elements.Phase.SOLID, 8, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/9/98/Plutonium3.jpg"),
    Am(95, "Americium", 243.0D, 1449.0D, 2880.0D, 12.0D, Elements.Phase.SOLID, 9, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Americium_microscope.jpg/440px-Americium_microscope.jpg"),
    Cm(96, "Curium", 247.0D, 1613.0D, 3383.0D, 13.51D, Elements.Phase.SOLID, 10, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/en/6/69/Curium.jpg"),
    Bk(97, "Berkelium", 247.0D, 1259.0D, 2900.0D, 14.78D, Elements.Phase.SOLID, 11, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/b/b6/Berkelium_metal.jpg"),
    Cf(98, "Californium", 251.0D, 1173.0D, 1743.0D, 15.1D, Elements.Phase.SOLID, 12, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/9/93/Californium.jpg"),
    Es(99, "Einsteinium", 252.0D, 1133.0D, 1269.0D, 8.84D, Elements.Phase.SOLID, 13, 9, Elements.Category.ACTINIDE, true, (Elements.Category)"https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Einsteinium.jpg/260px-Einsteinium.jpg"),
    Fm(100, "Fermium", 257.0D, 1800.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 14, 9, Elements.Category.ACTINIDE, true, (Elements.Category)""),
    Md(101, "Mendelevium", 258.0D, 1100.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 15, 9, Elements.Category.ACTINIDE, true, (Elements.Category)""),
    No(102, "Nobelium", 259.0D, 1100.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 16, 9, Elements.Category.ACTINIDE, true, (Elements.Category)""),
    Lr(103, "Lawrencium", 262.0D, 1900.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 17, 9, Elements.Category.ACTINIDE, true, (Elements.Category)""),
    Rf(104, "Rutherfordium", 261.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 4, 7, Elements.Category.TRANSITION, true, (Elements.Category)""),
    Db(105, "Dubnium", 262.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 5, 7, Elements.Category.TRANSITION, true, (Elements.Category)""),
    Sg(106, "Seaborgium", 266.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 6, 7, Elements.Category.TRANSITION, true, (Elements.Category)""),
    Bh(107, "Bohrium", 264.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 7, 7, Elements.Category.TRANSITION, true, (Elements.Category)""),
    Hs(108, "Hassium", 277.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 8, 7, Elements.Category.TRANSITION, true, (Elements.Category)""),
    Mt(109, "Meitnerium", 268.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 9, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Ds(110, "Darmstadtium", 281.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 10, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Rg(111, "Roentgenium", 281.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 11, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Cn(112, "Copernicium", 285.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 12, 7, Elements.Category.POST_TRANSITION, true, (Elements.Category)""),
    Nh(113, "Nihonium", 286.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 13, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Fl(114, "Flerovium", 289.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 14, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Mc(115, "Moscovium", 289.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 15, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Lv(116, "Livermorium", 293.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 16, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Ts(117, "Tennessine", 293.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 17, 7, Elements.Category.UNKNOWN, true, (Elements.Category)""),
    Og(118, "Oganesson", 294.0D, 0.0D, 0.0D, 0.0D, Elements.Phase.UNKNOWN, 18, 7, Elements.Category.UNKNOWN, true, (Elements.Category)"");
    
    private final int atomicNumber;
    
    private final String fullName;
    
    private final double atomicMass;
    
    private final double meltingPoint;
    
    private final double boilingPoint;
    
    private final double density;
    
    private final Elements.Phase phase;
    
    private int group;
    
    private int period;
    
    private final Elements.Category category;
    
    private final boolean radioactive;
    
    private final String imageUrl;
    
    private static class Holder {
      static Map<Integer, Elements.Element> map = new HashMap<>();
    }
    
    Element(int atomicNumber, String fullName, double atomicMass, double meltingPoint, double boilingPoint, double density, Elements.Phase phase, int group, int period, Elements.Category category, boolean radioactive, String imageUrl) {
      this.atomicNumber = atomicNumber;
      this.fullName = fullName;
      this.atomicMass = atomicMass;
      this.meltingPoint = meltingPoint;
      this.boilingPoint = boilingPoint;
      this.density = density;
      this.phase = phase;
      this.group = group;
      this.period = period;
      this.category = category;
      this.radioactive = radioactive;
      this.imageUrl = imageUrl;
      Holder.map.put(Integer.valueOf(atomicNumber), this);
    }
    
    public static Element forAtomicNumber(int atomicNumber) {
      return Holder.map.get(Integer.valueOf(atomicNumber));
    }
    
    public int getAtomicNumber() {
      return this.atomicNumber;
    }
    
    public String getFullName() {
      return this.fullName;
    }
    
    public double getAtomicMass() {
      return this.atomicMass;
    }
    
    public double getMeltingPoint() {
      return this.meltingPoint;
    }
    
    public double getBoilingPoint() {
      return this.boilingPoint;
    }
    
    public double getDensity() {
      return this.density;
    }
    
    public Elements.Phase getPhase() {
      return this.phase;
    }
    
    public int getGroup() {
      return this.group;
    }
    
    public int getPeriod() {
      return this.period;
    }
    
    public Elements.Category getCategory() {
      return this.category;
    }
    
    public boolean isRadioactive() {
      return this.radioactive;
    }
    
    public String getImageUrl() {
      return this.imageUrl;
    }
  }
}
